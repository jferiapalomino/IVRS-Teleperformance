package com.tp.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public final class InformacionAudios {
	
	public Audio buscarPorCodigo(String codigo, com.avaya.sce.runtimecommon.SCESession mySession)
	{
		List<Audio> ltAudios = new ArrayList<Audio>();
		Audio audio = new Audio();
		
		if(null != mySession.getProperty("audios")){
			ltAudios = (List<Audio>)mySession.getProperty("audios");
		}

		for(int i=0; i<ltAudios.size(); i++)
		{
			if(ltAudios.get(i).getCodigoAsociado1().toLowerCase().equals(codigo.toLowerCase()))
			{
				audio = (Audio)ltAudios.get(i);
				break;
			}
		}
		
		return audio;
	}
	
	public void cargarAudios(String jsonAudios, com.avaya.sce.runtimecommon.SCESession mySession)
	{
		try
		{
			List<Audio> ltAudios = new ArrayList<Audio>();
			
			if(null != mySession.getProperty("audios")){
				ltAudios = (List<Audio>)mySession.getProperty("audios");
			}
			
			if(ltAudios.size()>0) return;
			
			JSONObject obj = new JSONObject(jsonAudios);
			JSONArray arr = (JSONArray) obj.get("audioText");
			
			for(int i=0; i<arr.length(); i++)
			{
				JSONObject data = (JSONObject) arr.get(i);
				
				Audio audio = new Audio();
				audio.setAudioFile(data.get("AudioFile").toString());
				audio.setUrlAudio(data.get("AudioURL").toString());
				audio.setCodigoAsociado1(data.get("AssociatedCode1").toString());
				audio.setCodigoAsociado2(data.get("AssociatedCode2").toString());
				audio.setCodigoAsociado3(data.get("AssociatedCode3").toString());
				audio.setActivo(Boolean.parseBoolean(data.get("Active").toString()));
				
				ltAudios.add(audio);
			}
			
			mySession.setProperty("audios", ltAudios);
			
			CustomTracking.debug(mySession, "Cargando en mySession audios" );
			
		}
		catch(Exception ex)
		{
			CustomTracking.error(mySession, "Error cargando audios" + ex.getMessage());
			//ex.printStackTrace();
		}
	}
}
