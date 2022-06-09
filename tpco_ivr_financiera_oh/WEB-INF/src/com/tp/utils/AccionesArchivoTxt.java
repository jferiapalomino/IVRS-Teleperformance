package com.tp.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;

import flow.IProjectVariables;

public class AccionesArchivoTxt {

	public static void escribirArchivo(com.avaya.sce.runtimecommon.SCESession session, String datos) {
		FileWriter file = null;
		BufferedWriter bw = null;
		try {

			String nombreArchivo = session.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_SESSIONID).getStringValue();
			
			String UrlArchivoTxt = session.getVariableField(IProjectVariables.VAR_CONFIGURACION,IProjectVariables.VAR_CONFIGURACION_FIELD_URL_ARCHIVOS_TXT).getStringValue();

			String AppName = session.getAppName();
			if (AppName.startsWith("/")) {
				AppName = AppName.replaceAll("/", "");
			}

			String RealPath = session.getServlet().getServletContext().getRealPath("/");
			String pathDestino = RealPath.substring(0,RealPath.lastIndexOf(AppName));
			pathDestino = pathDestino + UrlArchivoTxt + AppName + "/";
			File dir = new File(pathDestino);

			if (!dir.exists()) {
				dir.mkdirs();
			}

			String ruta = pathDestino + nombreArchivo + ".txt";
			
			session.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Path: " + ruta);
			
			file = new FileWriter(ruta);
			bw = new BufferedWriter(file);
			bw.write(datos);
			

		} catch (Exception e) {
			session.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_ERROR,"Error escribiendo archivo de contingencia de llamada ... " +e.getMessage());
			//e.printStackTrace();
		}finally{
			Utils.closeQuietly(bw);
			Utils.closeQuietly(file);
		}
	}

	public static void EliminarArchivo(SCESession session) {

		try {

			String nombreArchivo = session.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_SESSIONID).getStringValue();
			
			String UrlArchivoTxt = session.getVariableField(IProjectVariables.VAR_CONFIGURACION,IProjectVariables.VAR_CONFIGURACION_FIELD_URL_ARCHIVOS_TXT).getStringValue();

			String AppName = session.getAppName();
			if (AppName.startsWith("/")) {
				AppName = AppName.replaceAll("/", "");
			}
			String RealPath = session.getServlet().getServletContext().getRealPath("/");
			String pathDestino = RealPath.substring(0,RealPath.lastIndexOf(AppName));
			pathDestino = pathDestino + UrlArchivoTxt + AppName + "/";
			String path = pathDestino + nombreArchivo + ".txt";
			File archivo = new File(path);
			boolean estatus = archivo.delete();
						
			if (!estatus) {
				session.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_ERROR,"El archivo no existe o no fue posible eliminarlo");

			} else {
				session.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Se ha eliminado el archivo exitosamente");
			}

		} catch (Exception e) {
			session.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_ERROR,"Error eliminando archivo de contingencia de llamada ... " +e.getMessage());
			//e.printStackTrace();
		}
	}
}