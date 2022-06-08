package com.tp.utils;

import java.net.InetAddress;

import org.json.JSONObject;

import com.avaya.sce.runtimecommon.IVariable;

import flow.IProjectVariables;

public class RegistrarLLamada {
	
	public static void RegistroLlamada(com.avaya.sce.runtimecommon.SCESession mySession) 
	{		
		JSONObject llamada = new JSONObject();
		try 
		{ 		
		
			String callId = "0";
			if (null != mySession.getProperty("callID")) {
				callId =  mySession.getProperty("callID").toString();
			}	
			llamada.put("CallId",callId);
			llamada.put("ANI",mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_ANI).getStringValue());
			llamada.put("SessionId",mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_SESSIONID).getStringValue());
			llamada.put("UCID",mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_UCID).getStringValue());
			llamada.put("DNIS",mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_DNIS).getStringValue());
			llamada.put("UUI",mySession.getVariable(IProjectVariables.AAI).getSimpleVariable().getStringValue());
			
			llamada.put("IpWas",InetAddress.getLocalHost().getHostAddress());
			llamada.put("ApplicationId",mySession.getVariableField(IProjectVariables.VAR_CONFIGURACION,IProjectVariables.VAR_CONFIGURACION_FIELD_CODIGO_APLICACION).getStringValue());
			llamada.put("AppName",mySession.getVariableField(IProjectVariables.VAR_CONFIGURACION,IProjectVariables.VAR_CONFIGURACION_FIELD_NOMBRE_APLICACION).getStringValue());
						
			String fechaInicio = mySession.getVariable(IProjectVariables.FECHA_INICIO_LLAMADA).getSimpleVariable().getStringValue(); 
			String fechaFin = mySession.getVariable(IProjectVariables.FECHA_FIN_LLAMADA).getSimpleVariable().getStringValue();
			
			if(fechaFin.equals("")) {
				llamada.put("StartDate",fechaInicio);	
			} else {
				llamada.put("StartDate",fechaInicio);	
				llamada.put("EndDate",fechaFin);
			}
				
			IVariable VariablesActualizacionLlamada = mySession.getVariable(IProjectVariables.REQUEST_UPDATE_CALL_DATA);
			
			llamada.put("Termination",VariablesActualizacionLlamada.getComplexVariable().getField(IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_TERMINATION).getStringValue());	
			llamada.put("JsonOptionsNavigation",VariablesActualizacionLlamada.getComplexVariable().getField(IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_JSON_OPTIONS_NAVIGATION).getStringValue());		   
			llamada.put("DocumentType",VariablesActualizacionLlamada.getComplexVariable().getField(IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_DOCUMENT_TYPE).getStringValue());
			llamada.put("DocumentNumber",VariablesActualizacionLlamada.getComplexVariable().getField(IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_DOCUMENT_NUMBER).getStringValue());
			llamada.put("DestinationNumber",VariablesActualizacionLlamada.getComplexVariable().getField(IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_DESTINATION_NUMBER).getStringValue());
			llamada.put("AdditionalData1",VariablesActualizacionLlamada.getComplexVariable().getField(IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_1).getStringValue());
			llamada.put("AdditionalData2",VariablesActualizacionLlamada.getComplexVariable().getField(IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_2).getStringValue());
			llamada.put("AdditionalData3",VariablesActualizacionLlamada.getComplexVariable().getField(IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_3).getStringValue());
			llamada.put("AdditionalData4",VariablesActualizacionLlamada.getComplexVariable().getField(IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_4).getStringValue());
			llamada.put("AdditionalData5",VariablesActualizacionLlamada.getComplexVariable().getField(IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_5).getStringValue());
			llamada.put("AdditionalData6",VariablesActualizacionLlamada.getComplexVariable().getField(IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_6).getStringValue());
			llamada.put("AdditionalData7",VariablesActualizacionLlamada.getComplexVariable().getField(IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_7).getStringValue());
			llamada.put("AdditionalData8",VariablesActualizacionLlamada.getComplexVariable().getField(IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_8).getStringValue());
			llamada.put("AdditionalData9",VariablesActualizacionLlamada.getComplexVariable().getField(IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_9).getStringValue());
			llamada.put("AdditionalData10",VariablesActualizacionLlamada.getComplexVariable().getField(IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_1_0).getStringValue());
			llamada.put("AdditionalData11",VariablesActualizacionLlamada.getComplexVariable().getField(IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_1_1).getStringValue());
			llamada.put("AdditionalData12",VariablesActualizacionLlamada.getComplexVariable().getField(IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_1_2).getStringValue());
			
			AccionesArchivoTxt.escribirArchivo(mySession, llamada.toString());
		} 
		catch (Exception e) 
		{
			CustomTracking.error(mySession,"Error escribiendo llamada en txt ... " +e.getMessage());
			//e.printStackTrace();
		} 
		finally 
		{
			llamada = null;
		}
	}
}