package spanish.grammars;

import com.tp.utils.CustomTracking;

import flow.IProjectVariables;

/**
 * This class is generated only initially.  It is expected that the developer
 * will edit this class can generate the necessary grammar.  The constructor will be regenerated
 * Last generated by Orchestration Designer at: (timestamp generation disabled)
 */
public class graDocumento extends com.avaya.sce.runtime.DynamicGrammar {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	* Constructor for graDocumento.  This method will be regenerated, put your initialization
	* logic in the init() method.
	*/
	public graDocumento() {
		//{{START:CLASS:CONSTRUCTOR
        setMode("dtmf");
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	* Method buildGrammar.  Subclasses must implement this method  and return an XML grammar.
	* To return a SRGS grammar, for Example,
	* <pre>
	*     <grammar type=" application / srgs + xml " root=" command " xml:lang=" en - US " version=" 1.0 ">
	*       <rule id=" command " scope=" public ">
	*          <one-of>
	*          <item>visa</item>
	*          <item>master</item>
	*          <item>master card</item>
	*          <item>amex</item>
	*          <item>american express</item>
	*          </one-of>
	*       </rule>
	*     </grammar>
	* </pre>
	* is the result of using the the grammar api as follows:
	* <pre>
	*  public void buildGrammar( SCESession mySession ) {
	*      com.avaya.sce.runtime.GrammarRule rule = new com.avaya.sce.runtime.GrammarRule();
	*      rule.add( new com.avaya.sce.runtime.GrammarItem( "visa" ) );
	*      rule.add( new com.avaya.sce.runtime.GrammarItem( "master card" ) );
	*      rule.add( new com.avaya.sce.runtime.GrammarItem( "amex" ) );
	*      rule.add( new com.avaya.sce.runtime.GrammarItem( "american express" ) );
	*      add( rule );
	*  }
	* </pre>
	*
	* To return a Google Speech grammar, for Example,
	* <pre>
	*  public void buildGrammar( SCESession mySession ) {
	*      setRawGrammarStr("<![CDATA[" + 
	*						"{ \"provider\": \"google\"}" + 
	*						"]]>");
	*  }
	* to produce the following:
	*<grammar mode="voice" type ="application/avaya-ep-csr" xml:lang="en-us">
	*	<![CDATA[
	*		{ "provider": "google"}
	*	]]>
	*</grammar>
	* </pre>
	* @return void
	* @see com.avaya.sce.runtime.DynamicGrammar#buildGrammar()
	*/
	public void buildGrammar(com.avaya.sce.runtimecommon.SCESession mySession) {

		String tipoDocumento = mySession.getVariableField(IProjectVariables.TIPO_DOCUMENTO_GRAMATICA).getStringValue().trim();
		
		String listaTipoDocumentos = mySession.getVariableField(IProjectVariables.VAR_CONFIGURACION,IProjectVariables.VAR_CONFIGURACION_FIELD_LISTA_TIPO_DOCUMENTOS_GRAMATICA).getStringValue();

		String regla = "";
		
		String reglaDefault = "";
		
		Boolean encontroConfiguracion = false;
		
		try {
			
			CustomTracking.info(mySession, "Inicia configuracion de gramatica de acuerdo con el tipo de documento seleccionado");
			
			CustomTracking.debug(mySession, "Lista de configuracion de gramaticas de los tipos de documentos: "+listaTipoDocumentos);
			
			CustomTracking.debug(mySession, "Tipo de documento seleccionado: "+tipoDocumento);
			
			String[] separacionTipoDocumento = listaTipoDocumentos.split(",");
			
			for (int i = 0; i < separacionTipoDocumento.length; i++) {

				String[] separacionConfigTipoDocumento = separacionTipoDocumento[i].split(":");
				
				if (tipoDocumento.equalsIgnoreCase(separacionConfigTipoDocumento[0].trim())) {

					CustomTracking.info(mySession, "Tipo de documento: "+tipoDocumento+" tiene configuracion");
					
					CustomTracking.debug(mySession, "La configuracion de la gramatica es: "+separacionConfigTipoDocumento[1]);
					
					regla = separacionConfigTipoDocumento[1];
					
					encontroConfiguracion = true;
				}
				
				if(separacionConfigTipoDocumento[0].equalsIgnoreCase("Otro Documento")) {
					reglaDefault = separacionConfigTipoDocumento[1];
				}
			}
			
			if (!encontroConfiguracion && !reglaDefault.isEmpty()) {
				
				regla = reglaDefault;
				
				CustomTracking.info(mySession, "No se encontro configuracion para el tipo de documento: "+tipoDocumento);
				
				CustomTracking.debug(mySession, "Se deja por defecto la configuracion de (Otro Documento): "+regla);
			}
			
			if (regla.isEmpty() || regla.equals("")) {

				regla = "1-20";
				
				CustomTracking.info(mySession, "No se encontro configuracion para el tipo de documento: "+tipoDocumento);
				
				CustomTracking.debug(mySession, "Se deja por defecto la configuracion: "+regla);
				
			}
			
			/**Limpiar variables
			 * */
			
		} catch (Exception e) {
			
			CustomTracking.error(mySession,"Hubo un error en asignar la gramatica: "+e);
			
			regla = "1-20";
			
			CustomTracking.debug(mySession, "Se deja por defecto la configuracion: "+regla);
			
		}
		
		/**Aca agrega la gramatica y los numeros permitidos a ingresar en el documento*/

		com.avaya.sce.runtime.GrammarRule rule = new com.avaya.sce.runtime.GrammarRule("Regla", regla);
		rule.add(new com.avaya.sce.runtime.GrammarItem("1"));
		rule.add(new com.avaya.sce.runtime.GrammarItem("2"));
		rule.add(new com.avaya.sce.runtime.GrammarItem("3"));
		rule.add(new com.avaya.sce.runtime.GrammarItem("4"));
		rule.add(new com.avaya.sce.runtime.GrammarItem("5"));
		rule.add(new com.avaya.sce.runtime.GrammarItem("6"));
		rule.add(new com.avaya.sce.runtime.GrammarItem("7"));
		rule.add(new com.avaya.sce.runtime.GrammarItem("8"));
		rule.add(new com.avaya.sce.runtime.GrammarItem("9"));
		rule.add(new com.avaya.sce.runtime.GrammarItem("0"));
		add(rule);
	}
}
