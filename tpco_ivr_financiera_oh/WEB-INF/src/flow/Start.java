package flow;

/**
 * This is a special reserved class that is repsonsible for loading application 
 * variables as well as the forward to the actual first form of the application.<br>
 * This class should not be manually edited as changes may be overridden by the 
 * code generator.<br>
 * Last generated by Orchestration Designer at: 5 DE NOVIEMBRE DE 2019 7:58:46 COT
 */
public class Start extends com.avaya.sce.runtime.Entry {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 5 DE NOVIEMBRE DE 2019 7:58:46 COT
	 */
	public Start() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * This method is generated automatically.  Any changes may be overwritten.
	 * Returns the submit object that will redirect application flow to the first
	 * form in the application.  This also adds various standard variables to the
	 * list of data to be submitted to the runtime variable table.
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 * @return the Submit object that contains the standard variables and the first form
	 */
	public com.avaya.sce.runtime.Submit getSubmit(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Submit submit = new com.avaya.sce.runtime.Submit("codIni");
		return ( submit );
	}
	/**
	 * This method initializes the SCE session with the variables that
	 * are defined in the application.<BR>
	 * 
	 * This method is generated automatically and should not be manually
	 * edited because changes may be overwritten by future code 
	 * generation.
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 */
	public void initializeVariables(com.avaya.sce.runtimecommon.SCESession session) {
		com.avaya.sce.runtimecommon.IVariable variable = null;
		String[] variableFields = null;

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.FLAG_FESTIVO, "", null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.VAR_SYSTEM_ERRORS_FIELD_COD_FINALIZACION,
			IProjectVariables.VAR_SYSTEM_ERRORS_FIELD_EVENT_MESSAGE,
			IProjectVariables.VAR_SYSTEM_ERRORS_FIELD_EVENT_NAME,
			IProjectVariables.VAR_SYSTEM_ERRORS_FIELD_TIPO_FINALIZACION };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.VAR_SYSTEM_ERRORS, variableFields, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.PATH, "", "com.avaya.vp.admin.variables.runtime.AdminVariableFactory", session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.RESPONSE_CONSULTA_CLIENTE_FIELD_CELULAR,
			IProjectVariables.RESPONSE_CONSULTA_CLIENTE_FIELD_CIUDAD,
			IProjectVariables.RESPONSE_CONSULTA_CLIENTE_FIELD_CODIGO_UNICO,
			IProjectVariables.RESPONSE_CONSULTA_CLIENTE_FIELD_CORREO,
			IProjectVariables.RESPONSE_CONSULTA_CLIENTE_FIELD_DIRECCION,
			IProjectVariables.RESPONSE_CONSULTA_CLIENTE_FIELD_NIT,
			IProjectVariables.RESPONSE_CONSULTA_CLIENTE_FIELD_NOMBRE,
			IProjectVariables.RESPONSE_CONSULTA_CLIENTE_FIELD_RAZON_SOCIAL,
			IProjectVariables.RESPONSE_CONSULTA_CLIENTE_FIELD_RESPONSE_CODE,
			IProjectVariables.RESPONSE_CONSULTA_CLIENTE_FIELD_RESPONSE_DESCRIPTION,
			IProjectVariables.RESPONSE_CONSULTA_CLIENTE_FIELD_SEGMENTO,
			IProjectVariables.RESPONSE_CONSULTA_CLIENTE_FIELD_TELEFONO };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.RESPONSE_CONSULTA_CLIENTE, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_1,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_1_0,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_1_1,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_1_2,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_2,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_3,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_4,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_5,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_6,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_7,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_8,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_9,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_ANI,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_APPLICATION_ID,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_APP_NAME,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_CALL_ID,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_DESTINATION_NUMBER,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_DNIS,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_DOCUMENT_NUMBER,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_DOCUMENT_TYPE,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_IP_WAS,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_JSON_OPTIONS_NAVIGATION,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_SESSION_ID,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_TERMINATION,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_UCID,
			IProjectVariables.REQUEST_UPDATE_CALL_DATA_FIELD_UUI };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.REQUEST_UPDATE_CALL_DATA, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.MEN_PRINCIPAL_FIELD_CONFIDENCE,
			IProjectVariables.MEN_PRINCIPAL_FIELD_INPUTMODE,
			IProjectVariables.MEN_PRINCIPAL_FIELD_INTERPRETATION,
			IProjectVariables.MEN_PRINCIPAL_FIELD_NOINPUTCOUNT,
			IProjectVariables.MEN_PRINCIPAL_FIELD_NOMATCHCOUNT,
			IProjectVariables.MEN_PRINCIPAL_FIELD_UTTERANCE,
			IProjectVariables.MEN_PRINCIPAL_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.MEN_PRINCIPAL, variableFields, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.VDN_DESBORDE, "", null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.VAR_CONFIGURACION_FIELD_CODIGO_APLICACION,
			IProjectVariables.VAR_CONFIGURACION_FIELD_DIAS_NO_TRABAJABLES,
			IProjectVariables.VAR_CONFIGURACION_FIELD_FESTIVOS_COLOMBIA,
			IProjectVariables.VAR_CONFIGURACION_FIELD_HABILITAR_HORARIO_DOMINGO,
			IProjectVariables.VAR_CONFIGURACION_FIELD_HABILITAR_HORARIO_FESTIVOS,
			IProjectVariables.VAR_CONFIGURACION_FIELD_HABILITAR_HORARIO_SABADO,
			IProjectVariables.VAR_CONFIGURACION_FIELD_HORARIO_DOMINGO,
			IProjectVariables.VAR_CONFIGURACION_FIELD_HORARIO_FESTIVOS,
			IProjectVariables.VAR_CONFIGURACION_FIELD_HORARIO_SABADO,
			IProjectVariables.VAR_CONFIGURACION_FIELD_HORARIO_SEMANA,
			IProjectVariables.VAR_CONFIGURACION_FIELD_INTENTOS_SOLICITA_DOCUMENTO,
			IProjectVariables.VAR_CONFIGURACION_FIELD_LISTA_TIPO_DOCUMENTOS_GRAMATICA,
			IProjectVariables.VAR_CONFIGURACION_FIELD_NOMBRE_APLICACION,
			IProjectVariables.VAR_CONFIGURACION_FIELD_PATH_CONSULTA_INFO_CLIENT,
			IProjectVariables.VAR_CONFIGURACION_FIELD_PATH_URL_AUDIOS_CLIENTE,
			IProjectVariables.VAR_CONFIGURACION_FIELD_PATH_URL_AUDIOS_ESTANDAR,
			IProjectVariables.VAR_CONFIGURACION_FIELD_REPETICIONES,
			IProjectVariables.VAR_CONFIGURACION_FIELD_TIME_OUT_CONNECTION,
			IProjectVariables.VAR_CONFIGURACION_FIELD_TIMEOUT_PROMPT_MENU,
			IProjectVariables.VAR_CONFIGURACION_FIELD_TIMEOUT_PROMPT_PAC,
			IProjectVariables.VAR_CONFIGURACION_FIELD_TIME_OUT_READ,
			IProjectVariables.VAR_CONFIGURACION_FIELD_URL_ARCHIVOS_TXT,
			IProjectVariables.VAR_CONFIGURACION_FIELD_URL_AUDIOS_TPTOOLS,
			IProjectVariables.VAR_CONFIGURACION_FIELD_URL_CONSULTA_INFO_CLIENT,
			IProjectVariables.VAR_CONFIGURACION_FIELD_URL_CONSULTA_LOG_IVR,
			IProjectVariables.VAR_CONFIGURACION_FIELD_VDN_MENU_PRINCIPAL_OP_1,
			IProjectVariables.VAR_CONFIGURACION_FIELD_VDN_MENU_PRINCIPAL_OP_2,
			IProjectVariables.VAR_CONFIGURACION_FIELD_VDN_MENU_PRINCIPAL_OP_3,
			IProjectVariables.VAR_CONFIGURACION_FIELD_VDN_MENU_PRINCIPAL_OP_4,
			IProjectVariables.VAR_CONFIGURACION_FIELD_VDN_MENU_TIPO_DOCUMENTO };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.VAR_CONFIGURACION, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.PAC_DOCUMENTO_FIELD_CONFIDENCE,
			IProjectVariables.PAC_DOCUMENTO_FIELD_INPUTMODE,
			IProjectVariables.PAC_DOCUMENTO_FIELD_INTERPRETATION,
			IProjectVariables.PAC_DOCUMENTO_FIELD_NOINPUTCOUNT,
			IProjectVariables.PAC_DOCUMENTO_FIELD_NOMATCHCOUNT,
			IProjectVariables.PAC_DOCUMENTO_FIELD_UTTERANCE,
			IProjectVariables.PAC_DOCUMENTO_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.PAC_DOCUMENTO, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.REDIRECTINFO_FIELD_PRESENTATIONINFO,
			IProjectVariables.REDIRECTINFO_FIELD_REASON,
			IProjectVariables.REDIRECTINFO_FIELD_SCREENINGINFO,
			IProjectVariables.REDIRECTINFO_FIELD_URI };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.REDIRECTINFO, variableFields, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.OPCION_MENU, "", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.BLIND_TRANSFER, "", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.CONTEXT_AUDIOS, "", "com.avaya.vp.admin.variables.runtime.AdminVariableFactory", session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.WEB_REQUEST_FIELD_ACCESS__TOKEN,
			IProjectVariables.WEB_REQUEST_FIELD_ERROR_MESSAGE,
			IProjectVariables.WEB_REQUEST_FIELD_IDCALL,
			IProjectVariables.WEB_REQUEST_FIELD_METHOD,
			IProjectVariables.WEB_REQUEST_FIELD_PARAMETERS,
			IProjectVariables.WEB_REQUEST_FIELD_RESPONSE,
			IProjectVariables.WEB_REQUEST_FIELD_TOKEN__TYPE,
			IProjectVariables.WEB_REQUEST_FIELD_TRACE_REQUEST,
			IProjectVariables.WEB_REQUEST_FIELD_URL };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.WEB_REQUEST, variableFields, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.AAI, "", null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.REQUEST_REGISTER_CALL_FIELD_ANI,
			IProjectVariables.REQUEST_REGISTER_CALL_FIELD_APPLICATION_ID,
			IProjectVariables.REQUEST_REGISTER_CALL_FIELD_APP_NAME,
			IProjectVariables.REQUEST_REGISTER_CALL_FIELD_DNIS,
			IProjectVariables.REQUEST_REGISTER_CALL_FIELD_IP_WAS,
			IProjectVariables.REQUEST_REGISTER_CALL_FIELD_SESSION_ID,
			IProjectVariables.REQUEST_REGISTER_CALL_FIELD_UCID,
			IProjectVariables.REQUEST_REGISTER_CALL_FIELD_UUI };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.REQUEST_REGISTER_CALL, variableFields, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.FECHA_INICIO_LLAMADA, "", null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.VARIABLES_VALIDAR_FIELD_DNIS_EXISTE,
			IProjectVariables.VARIABLES_VALIDAR_FIELD_DOCUMENTO,
			IProjectVariables.VARIABLES_VALIDAR_FIELD_PAIS };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.VARIABLES_VALIDAR, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.REQUEST_TPTOOLS_FIELD_TRANAPPLICATION_ID };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.REQUEST_TPTOOLS, variableFields, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.CANTIDAD_ERROR_RUNTIME, "0", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.STRING_JSONFILE, "", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.INTENTOS_REPETIR_DOCUMENTO, "", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.CANTIDAD_ERROR_BADFETCH, "0", null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DATE_FIELD_AUDIO,
			IProjectVariables.DATE_FIELD_DAYOFMONTH,
			IProjectVariables.DATE_FIELD_DAYOFWEEK,
			IProjectVariables.DATE_FIELD_DAYOFWEEKNUM,
			IProjectVariables.DATE_FIELD_DAYOFYEAR,
			IProjectVariables.DATE_FIELD_MONTH,
			IProjectVariables.DATE_FIELD_MONTHINYEAR,
			IProjectVariables.DATE_FIELD_YEAR };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DATE, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.REQUEST_CONSULTA_CLIENTE_FIELD_UNIQUE_COD };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.REQUEST_CONSULTA_CLIENTE, variableFields, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.DOCUMENTO, "", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.NOMBRE_SERVICIO, "", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.REPETICIONES, "", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.INTENTOS_PAC, "0", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.FLAG_HORARIO, "", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.INTENTOS_MENU, "0", null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.RESPONSE_TPTOOLS_FIELD_AUDIO_TEXT,
			IProjectVariables.RESPONSE_TPTOOLS_FIELD_MESSAGE,
			IProjectVariables.RESPONSE_TPTOOLS_FIELD_RESULT };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.RESPONSE_TPTOOLS, variableFields, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.URL_AUDIO, "", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.FECHA, "", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.EVENT__NAME, "", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.EVENT__MESSAGE, "", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.TIPO_DOCUMENTO_GRAMATICA, "", null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.MEN_TIPO_DOCUMENTO_FIELD_CONFIDENCE,
			IProjectVariables.MEN_TIPO_DOCUMENTO_FIELD_INPUTMODE,
			IProjectVariables.MEN_TIPO_DOCUMENTO_FIELD_INTERPRETATION,
			IProjectVariables.MEN_TIPO_DOCUMENTO_FIELD_NOINPUTCOUNT,
			IProjectVariables.MEN_TIPO_DOCUMENTO_FIELD_NOMATCHCOUNT,
			IProjectVariables.MEN_TIPO_DOCUMENTO_FIELD_UTTERANCE,
			IProjectVariables.MEN_TIPO_DOCUMENTO_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.MEN_TIPO_DOCUMENTO, variableFields, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.ERROR__MESSAGE, "OK", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.FECHA_FIN_LLAMADA, "", null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.SESSION_FIELD_AAI,
			IProjectVariables.SESSION_FIELD_ANI,
			IProjectVariables.SESSION_FIELD_CALLTAG,
			IProjectVariables.SESSION_FIELD_CHANNEL,
			IProjectVariables.SESSION_FIELD_CHANNELTYPE,
			IProjectVariables.SESSION_FIELD_CONVERSEFIRST,
			IProjectVariables.SESSION_FIELD_CONVERSESECOND,
			IProjectVariables.SESSION_FIELD_CURRENTLANGUAGE,
			IProjectVariables.SESSION_FIELD_DNIS,
			IProjectVariables.SESSION_FIELD_EXIT_CUSTOMER_ID,
			IProjectVariables.SESSION_FIELD_EXIT_INFO_1,
			IProjectVariables.SESSION_FIELD_EXIT_INFO_2,
			IProjectVariables.SESSION_FIELD_EXIT_PARENT_ID,
			IProjectVariables.SESSION_FIELD_EXIT_PREFERRED_PATH,
			IProjectVariables.SESSION_FIELD_EXIT_REASON,
			IProjectVariables.SESSION_FIELD_EXIT_TOPIC,
			IProjectVariables.SESSION_FIELD_LASTERROR,
			IProjectVariables.SESSION_FIELD_MEDIATYPE,
			IProjectVariables.SESSION_FIELD_PROTOCOLNAME,
			IProjectVariables.SESSION_FIELD_PROTOCOLVERSION,
			IProjectVariables.SESSION_FIELD_SESSIONID,
			IProjectVariables.SESSION_FIELD_SESSIONLABEL,
			IProjectVariables.SESSION_FIELD_SHAREDMODE,
			IProjectVariables.SESSION_FIELD_UCID,
			IProjectVariables.SESSION_FIELD_UUI,
			IProjectVariables.SESSION_FIELD_VIDEOBITRATE,
			IProjectVariables.SESSION_FIELD_VIDEOCODEC,
			IProjectVariables.SESSION_FIELD_VIDEOENABLED,
			IProjectVariables.SESSION_FIELD_VIDEOFARFMTP,
			IProjectVariables.SESSION_FIELD_VIDEOFORMAT,
			IProjectVariables.SESSION_FIELD_VIDEOFPS,
			IProjectVariables.SESSION_FIELD_VIDEOHEIGHT,
			IProjectVariables.SESSION_FIELD_VIDEONEARFMTP,
			IProjectVariables.SESSION_FIELD_VIDEOWIDTH,
			IProjectVariables.SESSION_FIELD_VPCALLEDEXTENSION,
			IProjectVariables.SESSION_FIELD_VPCONVERSEONDATA,
			IProjectVariables.SESSION_FIELD_VPCOVERAGEREASON,
			IProjectVariables.SESSION_FIELD_VPCOVERAGETYPE,
			IProjectVariables.SESSION_FIELD_VPRDNIS,
			IProjectVariables.SESSION_FIELD_VPREPORTURL };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.SESSION, variableFields, null, session, false, true );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.UUI, "", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.NOMBRE_ARCHIVO_TXT, "", null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.INFO_LOG_CALL_FIELD_CALLID };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.INFO_LOG_CALL, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DD_LAST_EXCEPTION_FIELD_ERRORCODE,
			IProjectVariables.DD_LAST_EXCEPTION_FIELD_MESSAGE,
			IProjectVariables.DD_LAST_EXCEPTION_FIELD_OBJECT,
			IProjectVariables.DD_LAST_EXCEPTION_FIELD_STACKTRACE,
			IProjectVariables.DD_LAST_EXCEPTION_FIELD_TYPE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DD_LAST_EXCEPTION, variableFields, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.ASSOCIATED_CODE_1, "", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.INTENTOS_REPETIR_MENU, "0", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.ASSOCIATED_CODE_2, "", null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.TIME_FIELD_AUDIO,
			IProjectVariables.TIME_FIELD_HOUR,
			IProjectVariables.TIME_FIELD_MILLISECOND,
			IProjectVariables.TIME_FIELD_MINUTE,
			IProjectVariables.TIME_FIELD_SECOND,
			IProjectVariables.TIME_FIELD_TIMEZONE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.TIME, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.SHAREDUUI_FIELD_ID,
			IProjectVariables.SHAREDUUI_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.SHAREDUUI, variableFields, null, session, false, false );
		session.putVariable(variable);
	}
	/**
	 * This method returns the name of the application.
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 */
	public String getEntryName() {
		return("tpco_ivr_financiera_oh");
	}
	/**
	 * This method returns a list of life cycle classes for Pluggable Connectors.
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 */
	public java.util.Collection getPluggableLifeCycle() {
		java.util.ArrayList result = new java.util.ArrayList();
		result.add("com.avaya.vp.admin.variables.runtime.Initializer");
		return(result);
	}
	/**
	 * This method returns a list of VXML contributor classes for Pluggable Connectors.
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 */
	public java.util.Collection getPluggableVXMLContrib() {
		java.util.ArrayList result = new java.util.ArrayList();
		return(result);
	}
	/**
	 * This method returns the root document for the application.
	 * This method is generated automatically and should not be modified
	 * because changes may be overwritten by future code generation.
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 */
	public String getRootDoc() {
		return("AppRoot");
	}
	/**
	 * Builds the list of input parameters that are defined for this application 
	 * entry.  This list is built automatically by adding Input Parameter
	 * nodes to AppRoot in the call flow editor.<BR>
	 *
	 * This method is generated automatically and changes to it may
	 * be overwritten next time code is generated.
	 *
	 * @return a Collection of <code>java.lang.String</code> objects that
	 * are the names of parameters the application is expecting.
	 * If the AppRoot node does not have any input parameters, then 
	 * this returns an empty list
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 */
	public java.util.Collection getInputParams(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		list = new java.util.ArrayList();

		return list;
	}
	/**
	 * Builds the list of capture expression that are defined for this application 
	 * entry.  This list is built automatically by adding Capture Expression
	 * items to AppRoot in the call flow editor.<BR>
	 *
	 * This method is generated automatically and changes to it may
	 * be overwritten next time code is generated.
	 *
	 * @return a Collection of <code>CaptureExpression</code> objects that
	 * specify the ECMA script expression and the Orchestration Designer 
	 * session variable that will store the captured result.
	 * If the AppRoot node does not have any capture expression items, then 
	 * this returns an empty list
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 */
	public java.util.Collection getCaptureExpressions(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		list = new java.util.ArrayList();

		return list;
	}
	/**
	 * This method returns a boolean to indicate if the approot node has a web page to show.
	 * This method is generated automatically and should not be modified
	 * because changes may be overwritten by future code generation.
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 */
	public boolean hasWebPage(com.avaya.sce.runtimecommon.SCESession mySession) {
		return false;
	}
}
