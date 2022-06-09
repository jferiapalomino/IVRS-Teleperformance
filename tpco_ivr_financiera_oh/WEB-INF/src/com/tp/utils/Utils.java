package com.tp.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PSource.PSpecified;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.avaya.sce.runtimecommon.IComplexVariable;
import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.IVariable;
import com.avaya.sce.runtimecommon.IVariableField;
import com.avaya.sce.runtimecommon.SCESession;

import flow.IProjectVariables;

public class Utils {

	public static void closeQuietly(InputStream input) {
		try {
			if (input != null) {
				input.close();
			}
		} catch (IOException ioe) {
			// ignore
		}
	}
	
	public static void closeQuietly(BufferedWriter bw) {
		try {
			if (bw != null) {
				bw.close();
			}
		} catch (IOException ioe) {
			// ignore
		}
	}
	
	public static void closeQuietly(OutputStreamWriter output) {
		try {
			if (output != null) {
				output.close();
			}
		} catch (IOException ioe) {
			// ignore
		}
	}
	
	public static void closeQuietly(InputStreamReader isr) {
		try {
			if (isr != null) {
				isr.close();
			}
		} catch (IOException ioe) {
			// ignore
		}
	}
	
	public static void closeQuietly(BufferedReader br) {
		try {
			if (br != null) {
				br.close();
			}
		} catch (IOException ioe) {
			// ignore
		}
		
	}

	public static void PrintValuesComplexVar (IVariable complexVarToFill, SCESession mySession){
	    String [] arrFieldNames = complexVarToFill.getComplexVariable().getFieldNames();
	    for(int i=0;i<arrFieldNames.length;i++) 
		{
	    	CustomTracking.debug(mySession,"Valor de campo : " +arrFieldNames[i]+ " = "+complexVarToFill.getComplexVariable().getField(arrFieldNames[i]).getStringValue());
	    }
	}
	
	public static boolean FillComplexVar(IVariable complexVarToFill, String rootNodeName, String jsonData, SCESession mySession){
		
		boolean respuesta = false;
		
		String[] arrFieldNames = null;
		JSONObject obj = null;
		JSONObject data = null;
		JSONArray arr = null; 
		
		String tagName = "";
		String tagValue = "";
		String varFieldName = "";
		try {
			arrFieldNames = complexVarToFill.getComplexVariable().getFieldNames();
			obj = new JSONObject(jsonData);
			
			if(rootNodeName != "")
			{
				try {

					arr = (JSONArray) obj.get(rootNodeName);
				    if(arr.length()>0 )
					{
						data = (JSONObject) arr.get(0);
						for(Iterator<String> iter = data.keys();iter.hasNext();) 
						{
							String key = iter.next();
							String value = data.get(key).toString();
							varFieldName = key;
							try {
								complexVarToFill.getComplexVariable().getField(varFieldName).setValue(value);
							} catch (Exception e) {
								CustomTracking.debug(mySession, "Campo : "+varFieldName+ "No existe en variable");
							}
						}
					}
				} 
				catch (Exception ex) 
				{
					data = (JSONObject) obj.get(rootNodeName);
					
					for (int i=0; i< arrFieldNames.length; i++)
					{
						varFieldName = arrFieldNames[i];
						try {
							complexVarToFill.getComplexVariable().getField(varFieldName).setValue(data.get(varFieldName).toString());
						} catch (Exception e) {
							CustomTracking.debug(mySession, "Campo : "+varFieldName+ "No existe en variable");
						}
					}
				} 
			}
			else
			{
				for(Iterator<String> iter = obj.keys();iter.hasNext();) 
				{
					String key = iter.next();
					String value = obj.get(key).toString();
					varFieldName = key;
					//CustomTracking.debug(mySession, "Campo a llenar: "+varFieldName+" : "+value);						
					
					try {
						complexVarToFill.getComplexVariable().getField(varFieldName).setValue(value);
					} catch (Exception e) {
						CustomTracking.error(mySession, "Campo: "+varFieldName+ " no existe en variable");
					}
				}
				CustomTracking.info(mySession, "Se llenaron los valores en la complex var con exito");
			}
			
			respuesta = true;
			
		} catch (JSONException ex) {
			CustomTracking.error(mySession, "Error FillComplexVar json no valido " + ex.getMessage());
		} catch (Exception e) {
			//e.printStackTrace();
			CustomTracking.error(mySession, "Error FillComplexVar " + e.getMessage());
		}
		finally 
		{
			if(null != arrFieldNames){
				arrFieldNames = null;
			}
			if(null != obj){
				obj = null;
			}
			if(null != data){
				data = null;
			}
			if(null!=arr){
				arr = null;
			}
		}
		return respuesta;
	}
	
	public static void FillSessionProperties(String rootNodeName, String jsonData, SCESession mySession){
		CustomTracking.debug(mySession, "propiedades...");
		try {
			JSONObject obj = new JSONObject(jsonData);
			if(rootNodeName != "")
			{
				JSONArray arr = (JSONArray) obj.get(rootNodeName);
			    if(arr.length()>0 )
				{
					JSONObject data = (JSONObject) arr.get(0);
					for(Iterator<String> iter = data.keys();iter.hasNext();) {
						String key = iter.next();
						String value = data.get(key).toString();
						//CustomTracking.debug(mySession, key +" : "+ value);
						mySession.setProperty(key, value);
					} 
				}
			}
			else
			{
				for(Iterator<String> iter = obj.keys();iter.hasNext();) {
					String key = iter.next();
					String value = obj.get(key).toString();
					mySession.setProperty(key, value);
				} 
			}	
		} catch (Exception e) {
			mySession.getTraceOutput().writeln(1, "Error cargando propiedades " + e.getMessage());
		}
	}
	
	public static Document createDocumentFromStringXml(String xmlString, SCESession session) throws Exception{
		StringReader sr=null;
		InputSource is=null;
		Document doc=null;
		try {
			
			DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();		
			DocumentBuilder builder = factory.newDocumentBuilder();	
			sr= new StringReader(xmlString);
			is=new  InputSource(sr);
			doc = builder.parse(is);
			return doc;
		} catch (Exception e) {
			session.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error creando xml string "+ e.getMessage());
			throw new Exception("Error creando xml string");
		}finally{
		   if(null!=sr){
			   sr.close();
		   }
		   if(null!=is){
			   is=null;
		   }
		}
	}
	
//	public static boolean sendPost(SCESession mySession, JSONObject json)
//	{
//		boolean respuesta = false;
//		
//		IVariable varConfiguracion;
//		IVariable VariablesRequest;
//		IVariable TokenInfo;
//		IVariable Parameters = null;	
//		
//		IVariableField ucid;
//		IVariableField ani;
//		IVariableField sessionid;
//		IVariableField Response;
//		IVariableField TimeoutConnection;
//		IVariableField TimeoutRead;
//		IVariableField URLConsulta;
//		IVariableField ErrorMessage = null;
//
//		String strURLConsulta;
//		String fieldParameters = "";
//		String fieldName= "";
//
//		String[] arrFieldNames = null;
//		List <NameValuePair> nvps = null;
//		JSONObject RequestParams = null;
//		DefaultHttpClient client = null;  
//		HttpParams my_httpParams = null;
//		HttpPost httpPost = null;
//		HttpEntity entity = null;
//		HttpResponse response = null;
//		
//		JSONObject jSONRequest = null;
//		JSONObject jSONResponse = null;
//		
//		try
//		{
//			System.setProperty("http.proxyHost", "127.0.0.1");
//		    System.setProperty("https.proxyHost", "127.0.0.1");
//		    System.setProperty("http.proxyPort", "8888");
//		    System.setProperty("https.proxyPort", "8888");
//		    
//			varConfiguracion = mySession.getVariable(IProjectVariables.VAR_CONFIGURACION);
//			VariablesRequest = mySession.getVariable(IProjectVariables.WEB_REQUEST);
//			
//			Response = VariablesRequest.getComplexVariable().getField(IProjectVariables.WEB_REQUEST_FIELD_RESPONSE);
//			TimeoutConnection = varConfiguracion.getComplexVariable().getField(IProjectVariables.VAR_CONFIGURACION_FIELD_TIME_OUT_CONNECTION);
//			TimeoutRead = varConfiguracion.getComplexVariable().getField(IProjectVariables.VAR_CONFIGURACION_FIELD_TIME_OUT_READ);
//			URLConsulta = VariablesRequest.getComplexVariable().getField(IProjectVariables.WEB_REQUEST_FIELD_URL);
//			ErrorMessage = VariablesRequest.getComplexVariable().getField(IProjectVariables.WEB_REQUEST_FIELD_ERROR_MESSAGE);
//			fieldParameters = VariablesRequest.getComplexVariable().getField(IProjectVariables.WEB_REQUEST_FIELD_PARAMETERS).getStringValue();
//			
//			String Method = VariablesRequest.getComplexVariable().getField(IProjectVariables.WEB_REQUEST_FIELD_METHOD).getStringValue();		
//			
//			String Access_token = VariablesRequest.getComplexVariable().getField(IProjectVariables.WEB_REQUEST_FIELD_ACCESS__TOKEN).getStringValue();
//			String Token_type = VariablesRequest.getComplexVariable().getField(IProjectVariables.WEB_REQUEST_FIELD_TOKEN__TYPE).getStringValue();
//			
//			strURLConsulta =  URLConsulta.getStringValue() + Method;
//			
//			RequestParams = new JSONObject();
//			
//			nvps = new ArrayList <NameValuePair>();
//			
//			if(Method.equalsIgnoreCase("token")) 
//			{
//				Parameters = mySession.getVariable(fieldParameters);
//				arrFieldNames = Parameters.getComplexVariable().getFieldNames();
//				
//				for(int i = 0; i < arrFieldNames.length; i++){
//					fieldName = arrFieldNames[i];
//					nvps.add(new BasicNameValuePair(fieldName, Parameters.getComplexVariable().getField(fieldName).getStringValue()));
//					RequestParams.put(fieldName, Parameters.getComplexVariable().getField(fieldName).getStringValue());
//				}	
//			} else {
//				if (json != null) {	
//					RequestParams = json;
//				}else {
//					if(!fieldParameters.equals(""))
//					{
//						Parameters = mySession.getVariable(fieldParameters);
//						arrFieldNames = Parameters.getComplexVariable().getFieldNames();
//						
//						for(int i = 0; i < arrFieldNames.length; i++){
//							fieldName = arrFieldNames[i];
//							RequestParams.put(fieldName, Parameters.getComplexVariable().getField(fieldName).getStringValue());
//						}	
//					}
//				}
//			}
//			
//            String strJsonRequest = RequestParams.toString();
//            try {
//            	jSONRequest = new JSONObject(RequestParams.toString());
//            	if (jSONRequest.has("publicKey")) {
//            		jSONRequest.put("publicKey","*** value skipped due to privacy ***");
//            	}
//            	if (jSONRequest.has("username")) {
//            		jSONRequest.put("username","*** value skipped due to privacy ***");
//            	}
//            	if (jSONRequest.has("password")) {
//            		jSONRequest.put("password","*** value skipped due to privacy ***");
//            	}
//            	if (jSONRequest.has("client_id")) {
//            		jSONRequest.put("client_id","*** value skipped due to privacy ***");
//            	}
//            	if (jSONRequest.has("encryptedData")) {
//            		jSONRequest.put("encryptedData","*** value skipped due to privacy ***");
//            	}
//            	strJsonRequest = jSONRequest.toString();
//			} catch (Exception e) {
//				// TODO: handle exception
//			}		
//			
//			CustomTracking.info(mySession, "URL:" + strURLConsulta);
//			CustomTracking.info(mySession, "Request:" + strJsonRequest);
//
//			//-----------------------------------------
//			
//			my_httpParams = new BasicHttpParams();
//			HttpConnectionParams.setConnectionTimeout(my_httpParams,  TimeoutConnection.getIntValue());  //connectionTimeoutMillis
//			HttpConnectionParams.setSoTimeout(my_httpParams, TimeoutRead.getIntValue()); //TimeoutRead  socketTimeoutMillis
//			
//	
//			client = new DefaultHttpClient(my_httpParams);
//			
//			httpPost = new HttpPost(strURLConsulta);
//			httpPost.addHeader("Accept", "application/json");
//			
//			if(Method.equalsIgnoreCase("token")) {
//				httpPost.addHeader("Content-Type","application/x-www-form-urlencoded");
//			} else {
//				httpPost.addHeader("Content-Type","application/json; charset=UTF-8");
//			}
//						
//			httpPost.addHeader("Connection", "keep-alive");
//			
//			if(!Access_token.equals("")) {
//				httpPost.addHeader("Authorization", Token_type + " " + Access_token);
//			}
//			
//			VariablesRequest.getComplexVariable().getField(IProjectVariables.WEB_REQUEST_FIELD_ACCESS__TOKEN).setValue("");
//			VariablesRequest.getComplexVariable().getField(IProjectVariables.WEB_REQUEST_FIELD_TOKEN__TYPE).setValue("");
//			
//			if (null != mySession.getProperty("callID")) {
//				httpPost.addHeader("CallID", mySession.getProperty("callID").toString());
//			}
//			
//			httpPost.addHeader("ucid", mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_UCID).getStringValue());
//			httpPost.addHeader("ani", mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_ANI).getStringValue());
//			httpPost.addHeader("sessionid", mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_SESSIONID).getStringValue());
//
//			if(Method.equalsIgnoreCase("token")) {
//				httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));	
//			} else {
//				httpPost.setEntity(new StringEntity(RequestParams.toString(), "utf-8"));
//			}
//
//		    response = client.execute(httpPost);
//		    
//		    int StatusCode = response.getStatusLine().getStatusCode();
//		    
//			CustomTracking.info(mySession, "StatusCode:" + Integer.toString(StatusCode));
//		    
//			entity = response.getEntity();
//			
//			if(StatusCode == 200 || StatusCode == 201)
//			{
//				if(entity != null) {
//					String results = EntityUtils.toString(entity, "utf-8");
//					
//		            String strJsonResponse = results;
//		            try {
//		            	jSONResponse = new JSONObject(results);
//		            	if (jSONResponse.has("client_id")) {
//		            		jSONResponse.put("client_id","*** value skipped due to privacy ***");
//		            	}
//		            	if (jSONResponse.has("public_key")) {
//		            		jSONResponse.put("public_key","*** value skipped due to privacy ***");
//		            	}
//		            	if (jSONResponse.has("token_type")) {
//		            		jSONResponse.put("token_type","*** value skipped due to privacy ***");
//		            	}
//		            	if (jSONResponse.has("access_token")) {
//		            		jSONResponse.put("access_token","*** value skipped due to privacy ***");
//		            	}
//		            	strJsonResponse = jSONResponse.toString();  	
//					} catch (Exception e) {
//						// TODO: handle exception
//					}		
//					
//					CustomTracking.info(mySession, "Response:" + strJsonResponse);
//					
//					//This method is called to indicate that the content of this entity is no longer required.  All entity implementations are expected to release all allocated resources as a result of this method invocation. 
//					entity.consumeContent();  
//					//response.getEntity().consumeContent();
//					Response.setValue(results);
//					ErrorMessage.setValue("OK");
//					respuesta = true;
//				}    
//				else
//				{
//					ErrorMessage.setValue("response empty");
//					CustomTracking.info(mySession, "response empty");
//				}
//			}
//			else
//			{
//				httpPost.abort();
//				ErrorMessage.setValue("ERROR_Status");
//				if(entity != null) {
//					String results = EntityUtils.toString(entity, "utf-8");
//					ErrorMessage.setValue("Error " + Method + " StatusCode:" + Integer.toString(StatusCode) + " Response:" + results);
//					CustomTracking.error(mySession, "Error " + Method + " StatusCode:" + Integer.toString(StatusCode) + " Response:" + results);
//					entity.consumeContent();
//				}else {
//					ErrorMessage.setValue("Error " + Method + " StatusCode:" + Integer.toString(StatusCode));
//					CustomTracking.error(mySession, "Error " + Method + " StatusCode:" + Integer.toString(StatusCode));
//				}
//			}	
//		}
//		catch (SocketTimeoutException e)
//		{
//		    // handle timeouts
//			ErrorMessage.setValue("Error SocketTimeoutException " + e.getMessage());
//			CustomTracking.error(mySession, "Error SocketTimeoutException " + e.getMessage());
//		}
//		catch (IOException e)
//		{
//		    // handle other IO exceptions
//			ErrorMessage.setValue("Error IOException " + e.getMessage());
//			CustomTracking.error(mySession, "Error IOException " + e.getMessage());
//		}
//		catch(Exception e)
//		{
//			ErrorMessage.setValue("Error Exception " + e.getMessage());
//			CustomTracking.error(mySession, "Error Exception " + e.getMessage());
//		} 
//		finally 
//		{
//			if(null != client){
//				client.getConnectionManager().shutdown();
//			}
//			client = null;
//			my_httpParams = null;
//			httpPost = null;
//			entity = null;
//			response = null;
//			jSONRequest = null;
//			jSONResponse = null;
//			if(null != arrFieldNames){
//				arrFieldNames = null;
//			}
//			if(null != RequestParams){
//				RequestParams = null;
//			}
//			if(null != nvps) {
//				nvps = null;
//			}
//		}		
//		return respuesta;
//	}
	
	public static boolean sendPost(SCESession mySession)
	{
		boolean respuesta = false;
		
		IVariable varConfiguracion;
		IVariable VariablesRequest;
		IVariable TokenInfo;
		IVariable Parameters = null;	
		IVariable LogInfo;
		IVariable VariablesSession;
		

		IVariableField ucid;
		IVariableField ani;
		IVariableField sessionid;
		IVariableField Response;
		IVariableField TimeoutConnection;
		IVariableField TimeoutRead;
		IVariableField URLConsulta;
		IVariableField ErrorMessage = null;
		IVariableField Method = null;		
	
		IVariableField CallID = null;
		
		String strURLConsulta;
		String fieldParameters = "";
		String fieldName= "";

		String[] arrFieldNames = null;
		JSONObject RequestParams = null;
		HttpClient client = null;  
		HttpParams my_httpParams = null;
		HttpPost httpPost = null;
		HttpEntity entity = null;
		HttpResponse response = null;
		
		try
		{
			System.setProperty("http.proxyHost", "127.0.0.1");
		    System.setProperty("https.proxyHost", "127.0.0.1");
		    System.setProperty("http.proxyPort", "8888");
		    System.setProperty("https.proxyPort", "8888");
		    
			LogInfo = mySession.getVariable(IProjectVariables.INFO_LOG_CALL);
			CallID = LogInfo.getComplexVariable().getField(IProjectVariables.INFO_LOG_CALL_FIELD_CALLID);
			
			varConfiguracion = mySession.getVariable(IProjectVariables.VAR_CONFIGURACION);
			VariablesRequest = mySession.getVariable(IProjectVariables.WEB_REQUEST);
			VariablesSession = mySession.getVariable(IProjectVariables.SESSION);
			
			Response = VariablesRequest.getComplexVariable().getField(IProjectVariables.WEB_REQUEST_FIELD_RESPONSE);
			TimeoutConnection = varConfiguracion.getComplexVariable().getField(IProjectVariables.VAR_CONFIGURACION_FIELD_TIME_OUT_CONNECTION);
			TimeoutRead = varConfiguracion.getComplexVariable().getField(IProjectVariables.VAR_CONFIGURACION_FIELD_TIME_OUT_READ);
			URLConsulta = VariablesRequest.getComplexVariable().getField(IProjectVariables.WEB_REQUEST_FIELD_URL);
			ErrorMessage = VariablesRequest.getComplexVariable().getField(IProjectVariables.WEB_REQUEST_FIELD_ERROR_MESSAGE);
			fieldParameters = VariablesRequest.getComplexVariable().getField(IProjectVariables.WEB_REQUEST_FIELD_PARAMETERS).getStringValue();
			
			Method = VariablesRequest.getComplexVariable().getField(IProjectVariables.WEB_REQUEST_FIELD_METHOD);			
			
			strURLConsulta =  URLConsulta.getStringValue() + Method.getStringValue();
			
			RequestParams = new JSONObject();
			
			if(!fieldParameters.equals(""))
			{
				Parameters = mySession.getVariable(fieldParameters);
				arrFieldNames = Parameters.getComplexVariable().getFieldNames();
				
				for(int i = 0; i < arrFieldNames.length; i++){
					fieldName = arrFieldNames[i];
					RequestParams.put(fieldName, Parameters.getComplexVariable().getField(fieldName).getStringValue());
				}	
			}
			else
			{
				arrFieldNames = new String[0];
			}
			
			CustomTracking.info(mySession,  "URL:" + strURLConsulta);
			CustomTracking.info(mySession,  "Request:" + RequestParams.toString());

			//-----------------------------------------
			
			my_httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(my_httpParams,  TimeoutConnection.getIntValue());  //connectionTimeoutMillis
			HttpConnectionParams.setSoTimeout(my_httpParams, TimeoutRead.getIntValue()); //TimeoutRead  socketTimeoutMillis
			
	
			client = new DefaultHttpClient(my_httpParams);
			
			httpPost = new HttpPost(strURLConsulta);
			httpPost.addHeader("Accept", "application/json");
			httpPost.addHeader("Content-Type","application/json; charset=UTF-8");
			httpPost.addHeader("Connection", "keep-alive");
			
			if (CallID.getStringValue() != "0"){
				httpPost.addHeader("CallID", CallID.getStringValue());
			}	
			
			IComplexVariable complexSession = VariablesSession.getComplexVariable();
			
			httpPost.addHeader("ucid", complexSession.getField(IProjectVariables.SESSION_FIELD_UCID).getStringValue());
			httpPost.addHeader("ani", complexSession.getField(IProjectVariables.SESSION_FIELD_ANI).getStringValue());
			httpPost.addHeader("sessionid", complexSession.getField(IProjectVariables.SESSION_FIELD_SESSIONID).getStringValue());

			httpPost.setEntity(new StringEntity(RequestParams.toString(), "utf-8"));
		    response = client.execute(httpPost);
		    
		    int StatusCode = response.getStatusLine().getStatusCode();
		    
			CustomTracking.info(mySession,  "StatusCode:" + Integer.toString(StatusCode));
		    
			entity = response.getEntity();
			
			if(StatusCode == 200 || StatusCode == 201)
			{
				if(entity != null) {
					String results = EntityUtils.toString(entity, "utf-8");
					
					CustomTracking.info(mySession,  "Response:" + results);
					
					if(Method.getStringValue().equals("Call/RegisterCall")){
						if(results != null && !results.isEmpty())
							CallID.setValue(results);
					}
					//This method is called to indicate that the content of this entity is no longer required.  All entity implementations are expected to release all allocated resources as a result of this method invocation. 
					entity.consumeContent();  
					//response.getEntity().consumeContent();
					Response.setValue(results);
					ErrorMessage.setValue("OK");
					respuesta = true;
				}    
				else
				{
					CustomTracking.info(mySession,  "response empty");
					ErrorMessage.setValue("ERROR_Empty");
				}
			}
			else
			{
				httpPost.abort();
				ErrorMessage.setValue("ERROR_Status");
				if(entity != null) {
					String results = EntityUtils.toString(entity, "utf-8");
					CustomTracking.error(mySession, "Error response middleware-api StatusCode:" + Integer.toString(StatusCode) + " Response:" + results);
					entity.consumeContent();
				}else {
					CustomTracking.error(mySession, "Error response middleware-api StatusCode:" + Integer.toString(StatusCode));
				}
			}	
		}
		catch (SocketTimeoutException e)
		{
		    // handle timeouts
			ErrorMessage.setValue("ERROR_SocketTimeoutException");
			CustomTracking.error(mySession, "Error SocketTimeoutException " + e.getMessage());
		}
		catch (IOException e)
		{
		    // handle other IO exceptions
			ErrorMessage.setValue("ERROR_IOException");
			CustomTracking.error(mySession, "Error IOException " + e.getMessage());
		}
		catch(Exception e)
		{
			CustomTracking.error(mySession, "Error Exception " + e.getMessage());
			//e.printStackTrace();
		} 
		finally 
		{
			if(null != client){
				client.getConnectionManager().shutdown();
			}
			client = null;
			my_httpParams = null;
			httpPost = null;
			entity = null;
			response = null;
			if(null != arrFieldNames){
				arrFieldNames = null;
			}
			if(null != RequestParams){
				RequestParams = null;
			}
		}		
		return respuesta;
	}
	
	
	public static boolean sendGet(SCESession mySession)
	{
		boolean respuesta = false;
		
		IVariable varConfiguracion;
		IVariable VariablesRequest;

		IVariableField Response;
		IVariableField TimeoutConnection;
		IVariableField TimeoutRead;
		IVariableField URLConsulta;
		IVariableField ErrorMessage = null;

		String strURLConsulta;
		
		HttpClient client = null;  
		HttpGet request = null;
		HttpParams my_httpParams = null;
		HttpEntity entity = null;
		HttpResponse response = null;
		
		try
		{
			varConfiguracion = mySession.getVariable(IProjectVariables.VAR_CONFIGURACION);
			TimeoutConnection = varConfiguracion.getComplexVariable().getField(IProjectVariables.VAR_CONFIGURACION_FIELD_TIME_OUT_CONNECTION);
			TimeoutRead = varConfiguracion.getComplexVariable().getField(IProjectVariables.VAR_CONFIGURACION_FIELD_TIME_OUT_READ);
			
			VariablesRequest = mySession.getVariable(IProjectVariables.WEB_REQUEST);
			URLConsulta = VariablesRequest.getComplexVariable().getField(IProjectVariables.WEB_REQUEST_FIELD_URL);
			ErrorMessage = VariablesRequest.getComplexVariable().getField(IProjectVariables.WEB_REQUEST_FIELD_ERROR_MESSAGE);
			Response = VariablesRequest.getComplexVariable().getField(IProjectVariables.WEB_REQUEST_FIELD_RESPONSE);

			strURLConsulta = URLConsulta.getStringValue();
			
			String[] Datos;
			Datos = strURLConsulta.split("\\?");
			
			strURLConsulta = Datos[0];
			String urlParameters = Datos[1];
			
			urlParameters = urlParameters.replace("\0", "");
			
			String[] QueryStrings = urlParameters.split("&");
			
			urlParameters = "";
			for(int i=0; i < QueryStrings.length; i++)
			{
				String[] Parameters = QueryStrings[i].split("=");
				String encode = "";
				if (Parameters.length > 1){
					encode = URLEncoder.encode(Parameters[1], "UTF-8");
				}
				if(i + 1 == QueryStrings.length){
					urlParameters = urlParameters + Parameters[0] + "=" + encode;
				}else{
					urlParameters = urlParameters + Parameters[0] + "=" + encode + "&";
				}
			}
			
			CustomTracking.info(mySession, "URL:" + strURLConsulta + "?" + urlParameters);
			
			//-------------------------
			
			my_httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(my_httpParams, TimeoutConnection.getIntValue());  //connectionTimeoutMillis
			HttpConnectionParams.setSoTimeout(my_httpParams, TimeoutRead.getIntValue()); //ReadTimeout socketTimeoutMillis
			
			client = new DefaultHttpClient(my_httpParams);
			
			request = new HttpGet(strURLConsulta + "?" + urlParameters);
			
			request.addHeader("Content-Type", "application/x-www-form-urlencoded");
			
			response = client.execute(request);
			
			int StatusCode = response.getStatusLine().getStatusCode();
			
			CustomTracking.info(mySession, "StatusCode:" + Integer.toString(StatusCode));
		    
			entity = response.getEntity();
						
			if (StatusCode != 200)
			{
				request.abort();
				ErrorMessage.setValue("ERROR_Status");
				if(entity != null) {
					String results = EntityUtils.toString(entity, "utf-8");
					CustomTracking.error(mySession, "Error response StatusCode:" + Integer.toString(StatusCode) + " Response:" + results);
					entity.consumeContent();
				}else {
					CustomTracking.error(mySession, "Error response StatusCode:" + Integer.toString(StatusCode));
				}
			}
			else
			{
				if(entity != null) {
					String results = EntityUtils.toString(entity, "utf-8");
					//This method is called to indicate that the content of this entity is no longer required.  All entity implementations are expected to release all allocated resources as a result of this method invocation. 
					entity.consumeContent();  
					//response.getEntity().consumeContent();
										
					Response.setValue(results);
					
					CustomTracking.info(mySession, "Response:" + results);
					
					ErrorMessage.setValue("OK");
					respuesta = true;
				}    
				else
				{
					ErrorMessage.setValue("response empty");
					CustomTracking.info(mySession, "response empty");
				}
			}
		}
		catch (SocketTimeoutException e)
		{
		    // handle timeouts
			ErrorMessage.setValue("Error SocketTimeoutException " + e.getMessage());
			CustomTracking.error(mySession, "Error SocketTimeoutException " + e.getMessage());
		}
		catch (IOException e)
		{
		    // handle other IO exceptions
			ErrorMessage.setValue("Error IOException " + e.getMessage());
			CustomTracking.error(mySession, "Error IOException " + e.getMessage());
		}
		catch(Exception e)
		{
			CustomTracking.error(mySession, "Error Exception " + e.getMessage());
		}
		finally 
		{
			if(null != client){
				client.getConnectionManager().shutdown();
			}
			client = null;
			request = null;
			my_httpParams = null;
			entity = null;
			response = null;
		}	
		return respuesta;
	}
	
	public static String socketCallCopy(String ip, int puerto, String type, String requestID, String deviceID, SCESession mySession) 
	{
		// need host and port, we want to connect to the ServerSocket at port 5620
		Socket socketClient = null;
		InputStreamReader streamReader = null;
		BufferedReader reader = null;

		String responseMessage = "";
		
		try
		{

			// need host and port, we want to connect to the ServerSocket at port 5620
	        socketClient = new Socket(ip, puerto);
	        
	        //Make a printwriter and write the message to the socket
	        PrintWriter writer = new PrintWriter(socketClient.getOutputStream());
	        writer.println("<REQUEST><REQUESTID>" + requestID + "</REQUESTID><TYPE>" + type + "</TYPE><DEVICEID>" + deviceID + "</DEVICEID></REQUEST>"); // <- println
	        writer.flush();// <- flush

	        //StreamReader to read the response from the server
	        streamReader = new InputStreamReader(socketClient.getInputStream());
	        reader = new BufferedReader(streamReader);

	        //Get the response message and print it to console
	        responseMessage = reader.readLine();
	        CustomTracking.info(mySession, "Response message socket: " + responseMessage);

	        reader.close();
	        writer.close();   // <- new location for close (*)
	        socketClient.close();
	                
		} catch (SocketTimeoutException s) {
	         CustomTracking.error(mySession, "Socket timed out " + s.getMessage());
	    } catch (IOException e) {
	         CustomTracking.error(mySession, "IOException " + e.getMessage());
	    }
		catch(Exception ex)
		{
			CustomTracking.error(mySession,"Error Socket " + ex.getMessage());
		}
		finally 
		{
			try {
				if (null != socketClient) {
					socketClient.close();
				}
			} catch (IOException ioe) {
				// ignore
			}
			try {
				if (null != streamReader) {
					streamReader.close();
				}
			} catch (IOException ioe) {
				// ignore
			}
			try {
				if (null != reader) {
					reader.close();
				}
			} catch (IOException ioe) {
				// ignore
			}
		}
        return responseMessage;
	}
		
	public static void agregarOpcion(String opcion, String descripcion, SCESession mySession, String additionalData1, String additionalData2, String additionalData3, String numberOption, String resultCode, String resultOperation){
		try {
			Thread.sleep(300);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			String fecha = sdf.format(date);
			JSONArray navigation = new JSONArray();
			if (null != mySession.getProperty("JsonOptionsNavigation")) {
				navigation = (JSONArray) mySession
						.getProperty("JsonOptionsNavigation");
			}else{
				 mySession
					.setProperty("JsonOptionsNavigation",navigation);
			}
			JSONObject option = new JSONObject();
			option.put("Option", opcion);
			if(descripcion.length() > 255) {
				option.put("Description", descripcion.substring(0, 255));
			} else {
				option.put("Description", descripcion);
			}
			option.put("Date", fecha);
			if(additionalData1.length() > 255) {
				option.put("AdditionalData1", additionalData1.substring(0, 255));
			} else {
				option.put("AdditionalData1", additionalData1);
			}
			if(additionalData2.length() > 255) {
				option.put("AdditionalData2", additionalData2.substring(0, 255));
			} else {
				option.put("AdditionalData2", additionalData2);
			}
			if(additionalData3.length() > 255) {
				option.put("AdditionalData3", additionalData3.substring(0, 255));
			} else {
				option.put("AdditionalData3", additionalData3);
			}
			option.put("NumberOption", numberOption);
			option.put("ResultCode", resultCode);
			option.put("ResultOperation", resultOperation);
			navigation.put(option);
		} catch (JSONException e) {
			CustomTracking.error(mySession, "Error agregando opcion : " + opcion + " - " + e.getMessage());
		}catch(Exception e){
			CustomTracking.error(mySession, "Error agregando opcion : " + opcion + " - " + e.getMessage());
		}
	}
	
	public static String blankIfNull(String s) {
		
		try {
			if(s == null) {
			    return "";
			}
			else if(s.equalsIgnoreCase("null")) {
				return "";
			} else {
				return s;
			}
		} catch (Exception e) {
			return s;
		}
	}
	
	public static boolean isNumeric(String strNum) {
	    try {
	        int d = Integer.parseInt(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static boolean isHexadecimal(String strHexa) {
	    try {
	    	boolean ret;
	    	// try to parse the string to an integer, using 16 as radix
	    	int t = Integer.parseInt(strHexa, 16);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static String construirTrama(String aai, SCESession mySession){
		
		String text = null;
		
		if (!aai.equalsIgnoreCase("")) {
			if (!aai.equalsIgnoreCase(null)) {				
				int pos = aai.indexOf("C8,");
				text = aai.substring(pos+3);
			}
		}
		
		String sep = ";";
		
		if (text != null && text.contains(sep)) {     
		    int posicion = text.indexOf(sep);
		    text = text.substring(0, posicion);              
		}else{
			CustomTracking.info(mySession, "Error validando el aai [construirTrama]");
		}
		
		return text;
	}
	
	public static String convertHexToString(String hex) {
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		try {
			for (int i = 0; i < hex.length() - 1; i += 2) {
				String output = hex.substring(i, (i + 2));
				// convert hex to decimal
				int decimal = Integer.parseInt(output, 16);
				// convert the decimal to character
				sb.append((char) decimal);
				temp.append(decimal);
			}
	
		} catch (Exception e) {
			sb = new StringBuilder();
			sb.append("error");
		}
		return sb.toString();
	}
	
    public static KeyPair buildKeyPair() throws NoSuchAlgorithmException {
        final int keySize = 2048;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        return keyPair;
    }
    
    public static String encryptRSA(String publicKey, String message) throws Exception {
    	PublicKey key = getPublicKey(publicKey);
    	//Cipher cipher = Cipher.getInstance("RSA");
    	//Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    	//Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
    	Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
    	//RSA/ECB/OAEPWithSHA-256AndMGF1WithSHA-1Padding
    	//RSA/ECB/OAEPWithSHA-256AndMGF1WithSHA-256Padding
        cipher.init(Cipher.ENCRYPT_MODE, key);
        int MaxLength = 190;
        if(message.length() > MaxLength) { 
        	short length = (short)((message.length()) / MaxLength);
        	String[] datos = new String[length + 1];
        	String sb = "";
        	for(int x = 0; x < datos.length + 1; x++) {
        		datos[x] = message.substring((x) * MaxLength, ((x) == length ? message.length() - MaxLength * length : MaxLength));
        		sb += Base64.getEncoder().encodeToString(cipher.doFinal(datos[x].getBytes("UTF-8")));
        	}
        	return sb;
        } else {
            return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));
        }
    }
    
    public static String encryptRSA(PublicKey publicKey, String message) throws Exception {
    	//Cipher cipher = Cipher.getInstance("RSA");
    	//Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    	//Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
    	Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
    	//RSA/ECB/OAEPWithSHA-256AndMGF1WithSHA-1Padding
    	//RSA/ECB/OAEPWithSHA-256AndMGF1WithSHA-256Padding
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        int MaxLength = 190;
        if(message.length() > MaxLength) { 
        	short length = (short)((message.length()) / MaxLength);
        	String[] datos = new String[length + 1];
        	String sb = "";
        	for(int x = 0; x < datos.length + 1; x++) {
        		datos[x] = message.substring((x) * MaxLength, ((x) == length ? message.length() - MaxLength * length : MaxLength));
        		sb += Base64.getEncoder().encodeToString(cipher.doFinal(datos[x].getBytes("UTF-8")));
        	}
        	return sb;
        } else {
            return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));
        }
    }
    
    public static String decryptRSA(PrivateKey key, String encrypted) throws Exception {
    	//Cipher cipher = Cipher.getInstance("RSA");
    	//Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");
        //cipher.init(Cipher.DECRYPT_MODE, privateKey);
        OAEPParameterSpec oaepParams = new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSpecified.DEFAULT);
        //OAEPParameterSpec oaepParams = new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSpecified.DEFAULT);
        cipher.init(Cipher.DECRYPT_MODE, key, oaepParams);
    	String[] datos = encrypted.split("\\,");
    	String sb = "";
    	for(int x = 0; x < datos.length; x++) {
    		sb += new String(cipher.doFinal(Base64.getDecoder().decode(datos[x])),"UTF-8");
    	}
    	return sb;
    }
    
    public static String decryptRSA(String privateKey, String encrypted) throws Exception {
    	privateKey = privateKey.replace("-----BEGIN PRIVATE KEY-----", "");  	
    	privateKey = privateKey.replace("-----END PRIVATE KEY-----", "");  	
    	PrivateKey key = getPrivateKey(privateKey);
    	//Cipher cipher = Cipher.getInstance("RSA");
    	//Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");
        //cipher.init(Cipher.DECRYPT_MODE, privateKey);
        OAEPParameterSpec oaepParams = new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSpecified.DEFAULT);
        //OAEPParameterSpec oaepParams = new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSpecified.DEFAULT);
        cipher.init(Cipher.DECRYPT_MODE, key, oaepParams);
    	String[] datos = encrypted.split("\\,");
    	String sb = "";
    	for(int x = 0; x < datos.length; x++) {
    		sb += new String(cipher.doFinal(Base64.getDecoder().decode(datos[x])),"UTF-8");
    	}
    	return sb;
    }
       
    public static PrivateKey getPrivateKey(String privateKey) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(privateKey.getBytes());
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }
    
    public static PublicKey getPublicKey(String publicKey) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(publicKey.getBytes());
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }
    
    public static String getFileInPath(String path) throws Exception {
    	
		File Archivo = new File (path);
		if(!Archivo.exists())
		{
			throw new Exception("Error no se encuentra archivo en path " +path);
		}
			
		FileReader frSecretFile = new FileReader(Archivo);
		BufferedReader brSecretFile = new BufferedReader(frSecretFile);
		String line;
		StringBuilder sbData = new StringBuilder();

		while((line=brSecretFile.readLine())!= null)
		{
			sbData.append(line.trim());
		}
		
		Utils.closeQuietly(brSecretFile);
		Utils.closeQuietly(frSecretFile);
		
		return sbData.toString();
    	
    }
    
	public String getZPKFromKeystore(String entry, String keystoreLocation, String keyStorePassword) throws Exception {

        KeyStore ks = KeyStore.getInstance("JCEKS");
        ks.load(null, keyStorePassword.toCharArray());
        KeyStore.PasswordProtection keyStorePP = new KeyStore.PasswordProtection(keyStorePassword.toCharArray());

        FileInputStream fIn = new FileInputStream(keystoreLocation);

        ks.load(fIn, keyStorePassword.toCharArray());

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBE");

        KeyStore.SecretKeyEntry ske = (KeyStore.SecretKeyEntry)ks.getEntry(entry, keyStorePP);

        PBEKeySpec keySpec = (PBEKeySpec)factory.getKeySpec(ske.getSecretKey(), PBEKeySpec.class);

        char[] password = keySpec.getPassword();

        return new String(password);

    }
	
	private static String encryptAESCBC(String message, String public_key) throws Exception
	{
        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        IvParameterSpec ivspec = new IvParameterSpec(iv);
       
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(public_key.toCharArray(), iv, 65536, 256);
        
        byte[] key = factory.generateSecret(spec).getEncoded();
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
               
        return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));  
	}

	public static String decryptAESCBC(String strToDecrypt, String secret) throws Exception {
	   
        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        IvParameterSpec ivspec = new IvParameterSpec(iv);
         
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(secret.toCharArray(), iv, 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
         
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)),"UTF-8");
	}
	
	//Teleperformance
	
	private static final String secretkey = "N3N3LjsmK3wvKHE9MTIwKi5aPD4rJ3w9";
	private static final String vec = "IzIzKC4qO3wqJzxZPk9vYS8oPys9JCVh";
	
	public static String decryptDES(String text) throws Exception {
    	byte arrIV[] = new String(Base64.getDecoder().decode(vec), "UTF-8").getBytes("UTF-8");
    	byte[] iv = new byte[8];
        for(int i = 0; i < arrIV.length && i < iv.length; ++i) {
        	iv[i] = arrIV[i];
        }
        final SecretKey key = new SecretKeySpec(new String(Base64.getDecoder().decode(secretkey), "UTF-8").getBytes("UTF-8"), "DESede");
        final IvParameterSpec ivspec = new IvParameterSpec(iv);
        final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, ivspec);
        byte[] arry = cipher.doFinal(hexStr2ByteArr(text));
        return new String(arry,"UTF-8");
	}
	
	public static String encryptDES(String text) throws Exception {
    	byte arrIV[] = new String(Base64.getDecoder().decode(vec), "UTF-8").getBytes("UTF-8");
    	byte[] iv = new byte[8];
        for(int i = 0; i < arrIV.length && i < iv.length; ++i) {
        	iv[i] = arrIV[i];
        }
        final SecretKey key = new SecretKeySpec(new String(Base64.getDecoder().decode(secretkey), "UTF-8").getBytes("UTF-8"), "DESede");
        final IvParameterSpec ivspec = new IvParameterSpec(iv);
        final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, ivspec);
        byte[] arry = cipher.doFinal(text.getBytes("UTF-8"));
        return byteArr2HexStr(arry);
	}
	
	//Byte array to hexadecimal string
	public static String byteArr2HexStr(byte[] arrB) {
        int iLen = arrB.length;
        StringBuffer sb = new StringBuffer(iLen * 2);
        for(int i = 0; i < iLen; ++i) {
            int intTmp;
            for(intTmp = arrB[i]; intTmp < 0; intTmp += 256) {
            }
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    // Hexadecimal string conversion byte array
    public static byte[] hexStr2ByteArr(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;
        byte[] arrOut = new byte[iLen / 2];
        for(int i = 0; i < iLen; i += 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte)Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }
	
}