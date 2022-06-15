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
		PHRASE_MAP = new com.avaya.sce.runtime.Phraseset.PhraseMap(24);
		com.avaya.sce.runtime.Phrase phrase;

		// phrase: MEN_PrincipalOP2
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "MEN_PrincipalOP2", "MEN_PrincipalOP2.wav", ""); 

		// phrase: PAC_SolicitaDocumento
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "PAC_SolicitaDocumento", "PAC_SolicitaCodigoUnico.wav", ""); 

		// phrase: ANU_FueraHorario
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "ANU_FueraHorario", "ANU_FueraHorario.wav", ""); 

		// phrase: ANU_Bienvenida
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "ANU_Bienvenida", "ANU_Bienvenida.wav", ""); 

		// phrase: ANU_TratamientoDatos
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "ANU_TratamientoDatos", "ANU_TratamientoDatos.wav", ""); 

		// phrase: MEN_TipoDocumento
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "MEN_TipoDocumento", "MEN_TipoDocumento.wav", ""); 

		// phrase: MEN_PrincipalOP3
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "MEN_PrincipalOP3", "MEN_PrincipalOP3.wav", ""); 

		// phrase: MEN_PrincipalOP4
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "MEN_PrincipalOP4", "MEN_PrincipalOP4.wav", ""); 

		// phrase: MEN_PrincipalOP5
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "MEN_PrincipalOP5", "MEN_PrincipalOP5.wav", ""); 

		// phrase: MEN_PrincipalOP6
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "MEN_PrincipalOP6", "MEN_PrincipalOP6.wav", ""); 

		// phrase: MEN_PrincipalOP7
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "MEN_PrincipalOP7", "MEN_PrincipalOP7.wav", ""); 

		// phrase: MEN_PrincipalOP9
		com.avaya.sce.runtime.Phraseset.addExternalPhrase(PHRASE_MAP, "spanish.phraseset.codFrases.urlbase", "MEN_PrincipalOP9", "MEN_PrincipalOP9.wav", ""); 

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
