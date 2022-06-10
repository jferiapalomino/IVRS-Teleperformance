package spanish.phrasesets;

import java.net.MalformedURLException;
import java.net.URL;

import com.avaya.sce.runtime.ExternalPhrase;
import com.avaya.sce.runtime.Phrase;
import com.tp.utils.CustomTracking;

import flow.IProjectVariables;

/**
 * This phraseset class will be automatically populated with data from the 
 * phraseset project file.  Manual edits should only be outside of the tag 
 * areas or overridden methods. 
 * Class created on: 
 * Last generated by Orchestration Designer at: (timestamp generation disabled)
 */
public class codFrases extends com.avaya.sce.runtime.Phraseset { 

	//{{START:CLASS:FIELDS
	private static final com.avaya.sce.runtime.Phraseset.PhraseMap PHRASE_MAP;
	//}}END:CLASS:FIELDS

	/**
	 * Static initializer
	 */
	static {
		//{{START:PHRASESET:STATIC

		// Create the phrase map, then populate with phrases
		PHRASE_MAP = new com.avaya.sce.runtime.Phraseset.PhraseMap(26);
		com.avaya.sce.runtime.Phrase phrase;

		// phrase: ANU_ComercioAfiliadoRedeban
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "ANU_ComercioAfiliadoRedeban", "ANU_ComercioAfiliadoRedeban.wav", ""); 

		// phrase: ANU_IntentoDosCodigoUnico
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "ANU_IntentoDosCodigoUnico", "ANU_IntentoDosCodigoUnico.wav", ""); 

		// phrase: ANU_IntentoUnoCodigoUnico
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "ANU_IntentoUnoCodigoUnico", "ANU_IntentoUnoCodigoUnico.wav", ""); 

		// phrase: ANU_LlamadaGrabadaMonitoriada
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "ANU_LlamadaGrabadaMonitoriada", "ANU_LlamadaGrabadaMonitoriada.wav", ""); 

		// phrase: ANU_SuCodigoEs
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "ANU_SuCodigoEs", "ANU_SuCodigoEs.wav", ""); 

		// phrase: ANU_Transferencia
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "ANU_Transferencia", "ANU_Transferencia.wav", ""); 

		// phrase: MEN_ConfirmarCodigoUnico
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "MEN_ConfirmarCodigoUnico", "MEN_ConfirmarCodigoUnico.wav", ""); 

		// phrase: MEN_Principal
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "MEN_Principal", "MEN_Principal.wav", ""); 

		// phrase: MEN_SoporteTecnico
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "MEN_SoporteTecnico", "MEN_SoporteTecnico.wav", ""); 

		// phrase: PAC_SolicitaCodigoUnico
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "PAC_SolicitaCodigoUnico", "PAC_SolicitaCodigoUnico.wav", ""); 

		// phrase: ANU_ValidacionHorario
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "ANU_ValidacionHorario", "ANU_ValidacionHorario.wav", ""); 

		// phrase: ANU_Bienvenida
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "ANU_Bienvenida", "ANU_Bienvenida.wav", ""); 

		// phrase: PAC_SolicitaDocumento
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "PAC_SolicitaDocumento", "PAC_SolicitaDocumento.wav", ""); 

		//}}END:PHRASESET:STATIC
	}
	/**
	 * Returns the Phrase with the given name.  To override the
	 * behavior and dynamically return a different Phrase object,
	 * override the method "hookGetPhrase(...)".
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 * @see com.avaya.sce.runtime.Phraseset#getPhrase(String) 
	 */ 
	public com.avaya.sce.runtime.Phrase getPhrase(String phraseName) {
		return(getPhrase(codFrases.PHRASE_MAP, phraseName));
	}
	

	@Override
	public Phrase hookGetPhrase(String phraseName, Phrase phrase) {
		try {
			if(PHRASE_MAP.get(phraseName)==null) {
				return phrase;
			}
			URL url = new URL( getMySession().getRequest().getRequestURL().toString());
			String path = getMySession().getVariableField(IProjectVariables.VAR_CONFIGURACION,IProjectVariables.VAR_CONFIGURACION_FIELD_PATH_URL_AUDIOS_CLIENTE).getStringValue();
			URL newUrl = new URL(url.getProtocol(),url.getHost(),url.getPort(),path+PHRASE_MAP.get(phraseName).getFileName());
			CustomTracking.debug(getMySession(),"URL audio reproducir: ".concat(newUrl.toString()));
			return new ExternalPhrase(newUrl.toString());
		} catch (MalformedURLException e) {
			return phrase;
		}								
	}
}
