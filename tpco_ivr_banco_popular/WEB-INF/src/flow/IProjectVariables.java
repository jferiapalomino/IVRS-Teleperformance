package flow;

/**
 * This interface is used to define the name of variables that are 
 * declared in the call flow.  All variables are defined as 
 * <code>public static final String</code>, which allows user-defined
 * code to reference variable names by the Java variable name.
 * Last generated by Orchestration Designer at: 5 DE NOVIEMBRE DE 2019 7:58:46 COT
 */
public interface IProjectVariables {





	//{{START:PROJECT:VARIABLES
	/**
	 * This is a reserved block of variable name definitions.
	 * The variable names defined here can be used as the key
	 * to get the <code>com.avaya.sce.runtime.Variable</code>
	 * from the <code>SCESession</code> at runtime.<br>
	 * 
	 * For example, given a variable name <code>phoneNum</code>,
	 * user-defined code should access the variable in this format:<PRE>
	 *   Variable phNum = mySession.getVariable(IProjectVariables.PHONE_NUM);
	 *   if ( phNum != null ) {
	 *        // do something with the variable
	 *   }</PRE>
	 * 
	 * This block of code is generated automatically by Orchestration Designer and should not
	 * be manually edited as changes may be overwritten by future code generation.
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 */
	public static final String FLAG_FESTIVO = "flagFestivo";
	public static final String MEN_ESTADO_SINIESTRO = "menEstadoSiniestro";
	public static final String VAR_SYSTEM_ERRORS = "varSystemErrors";
	public static final String PATH = "path";
	public static final String RESPONSE_CONSULTA_CLIENTE = "responseConsultaCliente";
	public static final String REQUEST_UPDATE_CALL_DATA = "requestUpdateCallData";
	public static final String MEN_PRINCIPAL = "menPrincipal";
	public static final String VDN_DESBORDE = "vdnDesborde";
	public static final String VAR_CONFIGURACION = "varConfiguracion";
	public static final String PAC_DOCUMENTO = "pacDocumento";
	public static final String REDIRECTINFO = "redirectinfo";
	public static final String MEN_INFORMACION_ECOSISTEMA = "menInformacionEcosistema";
	public static final String OPCION_MENU = "opcionMenu";
	public static final String BLIND_TRANSFER = "BlindTransfer";
	public static final String CONTEXT_AUDIOS = "contextAudios";
	public static final String WEB_REQUEST = "webRequest";
	public static final String AAI = "aai";
	public static final String REQUEST_REGISTER_CALL = "requestRegisterCall";
	public static final String FECHA_INICIO_LLAMADA = "fechaInicioLlamada";
	public static final String VARIABLES_VALIDAR = "variablesValidar";
	public static final String REQUEST_TPTOOLS = "requestTPTools";
	public static final String CANTIDAD_ERROR_RUNTIME = "cantidadErrorRuntime";
	public static final String STRING_JSONFILE = "stringJSONFile";
	public static final String INTENTOS_REPETIR_DOCUMENTO = "intentosRepetirDocumento";
	public static final String CANTIDAD_ERROR_BADFETCH = "cantidadErrorBadfetch";
	public static final String DATE = "date";
	public static final String REQUEST_CONSULTA_CLIENTE = "requestConsultaCliente";
	public static final String DOCUMENTO = "documento";
	public static final String NOMBRE_SERVICIO = "NombreServicio";
	public static final String REPETICIONES = "repeticiones";
	public static final String INTENTOS_PAC = "intentosPac";
	public static final String FLAG_HORARIO = "flagHorario";
	public static final String MEN_FUERA_HORARIO = "MenFueraHorario";
	public static final String INTENTOS_MENU = "intentosMenu";
	public static final String RESPONSE_TPTOOLS = "responseTPTools";
	public static final String URL_AUDIO = "UrlAudio";
	public static final String FECHA = "fecha";
	public static final String EVENT__NAME = "event_name";
	public static final String EVENT__MESSAGE = "event_message";
	public static final String TIPO_DOCUMENTO_GRAMATICA = "TipoDocumentoGramatica";
	public static final String MEN_TIPO_DOCUMENTO = "menTipoDocumento";
	public static final String ERROR__MESSAGE = "ERROR_MESSAGE";
	public static final String FECHA_FIN_LLAMADA = "fechaFinLlamada";
	public static final String SESSION = "session";
	public static final String UUI = "uui";
	public static final String NOMBRE_ARCHIVO_TXT = "NombreArchivoTxt";
	public static final String INFO_LOG_CALL = "infoLogCall";
	public static final String DD_LAST_EXCEPTION = "ddLastException";
	public static final String ASSOCIATED_CODE_1 = "associatedCode1";
	public static final String INTENTOS_REPETIR_MENU = "intentosRepetirMenu";
	public static final String ASSOCIATED_CODE_2 = "associatedCode2";
	public static final String TIME = "time";
	public static final String SHAREDUUI = "shareduui";
	//}}END:PROJECT:VARIABLES
	//{{START:PROJECT:VARIABLEFIELDS
	public static final String MEN_ESTADO_SINIESTRO_FIELD_CONFIDENCE = "confidence";
	public static final String MEN_ESTADO_SINIESTRO_FIELD_INPUTMODE = "inputmode";
	public static final String MEN_ESTADO_SINIESTRO_FIELD_INTERPRETATION = "interpretation";
	public static final String MEN_ESTADO_SINIESTRO_FIELD_NOINPUTCOUNT = "noinputcount";
	public static final String MEN_ESTADO_SINIESTRO_FIELD_NOMATCHCOUNT = "nomatchcount";
	public static final String MEN_ESTADO_SINIESTRO_FIELD_UTTERANCE = "utterance";
	public static final String MEN_ESTADO_SINIESTRO_FIELD_VALUE = "value";
	public static final String VAR_SYSTEM_ERRORS_FIELD_COD_FINALIZACION = "codFinalizacion";
	public static final String VAR_SYSTEM_ERRORS_FIELD_EVENT_MESSAGE = "eventMessage";
	public static final String VAR_SYSTEM_ERRORS_FIELD_EVENT_NAME = "eventName";
	public static final String VAR_SYSTEM_ERRORS_FIELD_TIPO_FINALIZACION = "tipoFinalizacion";
	public static final String RESPONSE_CONSULTA_CLIENTE_FIELD_CELULAR = "Celular";
	public static final String RESPONSE_CONSULTA_CLIENTE_FIELD_CIUDAD = "Ciudad";
	public static final String RESPONSE_CONSULTA_CLIENTE_FIELD_CODIGO_UNICO = "CodigoUnico";
	public static final String RESPONSE_CONSULTA_CLIENTE_FIELD_CORREO = "Correo";
	public static final String RESPONSE_CONSULTA_CLIENTE_FIELD_DIRECCION = "Direccion";
	public static final String RESPONSE_CONSULTA_CLIENTE_FIELD_NIT = "Nit";
	public static final String RESPONSE_CONSULTA_CLIENTE_FIELD_NOMBRE = "Nombre";
	public static final String RESPONSE_CONSULTA_CLIENTE_FIELD_RAZON_SOCIAL = "RazonSocial";
	public static final String RESPONSE_CONSULTA_CLIENTE_FIELD_RESPONSE_CODE = "ResponseCode";
	public static final String RESPONSE_CONSULTA_CLIENTE_FIELD_RESPONSE_DESCRIPTION = "ResponseDescription";
	public static final String RESPONSE_CONSULTA_CLIENTE_FIELD_SEGMENTO = "Segmento";
	public static final String RESPONSE_CONSULTA_CLIENTE_FIELD_TELEFONO = "Telefono";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_1 = "AdditionalData1";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_1_0 = "AdditionalData10";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_1_1 = "AdditionalData11";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_1_2 = "AdditionalData12";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_2 = "AdditionalData2";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_3 = "AdditionalData3";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_4 = "AdditionalData4";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_5 = "AdditionalData5";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_6 = "AdditionalData6";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_7 = "AdditionalData7";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_8 = "AdditionalData8";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_ADDITIONAL_DATA_9 = "AdditionalData9";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_ANI = "ANI";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_APPLICATION_ID = "ApplicationId";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_APP_NAME = "AppName";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_CALL_ID = "CallId";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_DESTINATION_NUMBER = "DestinationNumber";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_DNIS = "DNIS";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_DOCUMENT_NUMBER = "DocumentNumber";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_DOCUMENT_TYPE = "DocumentType";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_IP_WAS = "IpWAS";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_JSON_OPTIONS_NAVIGATION = "JsonOptionsNavigation";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_SESSION_ID = "SessionId";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_TERMINATION = "Termination";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_UCID = "UCID";
	public static final String REQUEST_UPDATE_CALL_DATA_FIELD_UUI = "UUI";
	public static final String MEN_PRINCIPAL_FIELD_CONFIDENCE = "confidence";
	public static final String MEN_PRINCIPAL_FIELD_INPUTMODE = "inputmode";
	public static final String MEN_PRINCIPAL_FIELD_INTERPRETATION = "interpretation";
	public static final String MEN_PRINCIPAL_FIELD_NOINPUTCOUNT = "noinputcount";
	public static final String MEN_PRINCIPAL_FIELD_NOMATCHCOUNT = "nomatchcount";
	public static final String MEN_PRINCIPAL_FIELD_UTTERANCE = "utterance";
	public static final String MEN_PRINCIPAL_FIELD_VALUE = "value";
	public static final String VAR_CONFIGURACION_FIELD_CODIGO_APLICACION = "codigoAplicacion";
	public static final String VAR_CONFIGURACION_FIELD_DIAS_NO_TRABAJABLES = "diasNoTrabajables";
	public static final String VAR_CONFIGURACION_FIELD_FESTIVOS_COLOMBIA = "festivosColombia";
	public static final String VAR_CONFIGURACION_FIELD_HABILITAR_HORARIO_DOMINGO = "habilitarHorarioDomingo";
	public static final String VAR_CONFIGURACION_FIELD_HABILITAR_HORARIO_FESTIVOS = "habilitarHorarioFestivos";
	public static final String VAR_CONFIGURACION_FIELD_HABILITAR_HORARIO_SABADO = "habilitarHorarioSabado";
	public static final String VAR_CONFIGURACION_FIELD_HORARIO_DOMINGO = "horarioDomingo";
	public static final String VAR_CONFIGURACION_FIELD_HORARIO_FESTIVOS = "horarioFestivos";
	public static final String VAR_CONFIGURACION_FIELD_HORARIO_SABADO = "horarioSabado";
	public static final String VAR_CONFIGURACION_FIELD_HORARIO_SEMANA = "horarioSemana";
	public static final String VAR_CONFIGURACION_FIELD_INTENTOS_SOLICITA_DOCUMENTO = "intentosSolicitaDocumento";
	public static final String VAR_CONFIGURACION_FIELD_LISTA_TIPO_DOCUMENTOS_GRAMATICA = "listaTipoDocumentosGramatica";
	public static final String VAR_CONFIGURACION_FIELD_NOMBRE_APLICACION = "nombreAplicacion";
	public static final String VAR_CONFIGURACION_FIELD_PATH_CONSULTA_INFO_CLIENT = "pathConsultaInfoClient";
	public static final String VAR_CONFIGURACION_FIELD_PATH_URL_AUDIOS_CLIENTE = "pathUrlAudiosCliente";
	public static final String VAR_CONFIGURACION_FIELD_PATH_URL_AUDIOS_ESTANDAR = "pathUrlAudiosEstandar";
	public static final String VAR_CONFIGURACION_FIELD_REPETICIONES = "repeticiones";
	public static final String VAR_CONFIGURACION_FIELD_TIME_OUT_CONNECTION = "timeOutConnection";
	public static final String VAR_CONFIGURACION_FIELD_TIMEOUT_PROMPT_MENU = "timeoutPromptMenu";
	public static final String VAR_CONFIGURACION_FIELD_TIMEOUT_PROMPT_PAC = "timeoutPromptPac";
	public static final String VAR_CONFIGURACION_FIELD_TIME_OUT_READ = "timeOutRead";
	public static final String VAR_CONFIGURACION_FIELD_URL_ARCHIVOS_TXT = "urlArchivosTxt";
	public static final String VAR_CONFIGURACION_FIELD_URL_AUDIOS_TPTOOLS = "urlAudiosTPTools";
	public static final String VAR_CONFIGURACION_FIELD_URL_CONSULTA_INFO_CLIENT = "urlConsultaInfoClient";
	public static final String VAR_CONFIGURACION_FIELD_URL_CONSULTA_LOG_IVR = "urlConsultaLogIvr";
	public static final String VAR_CONFIGURACION_FIELD_VDN_MENU_ESTADO_SINIESTRO_OP_1 = "vdnMenuEstadoSiniestroOP1";
	public static final String VAR_CONFIGURACION_FIELD_VDN_MENU_ESTADO_SINIESTRO_OP_2 = "vdnMenuEstadoSiniestroOP2";
	public static final String VAR_CONFIGURACION_FIELD_VDN_MENU_FUERA_HORARIO = "vdnMenuFueraHorario";
	public static final String VAR_CONFIGURACION_FIELD_VDN_MENU_INFORMACION_ECOSISTEMA_OP_1 = "vdnMenuInformacionEcosistemaOP1";
	public static final String VAR_CONFIGURACION_FIELD_VDN_MENU_INFORMACION_ECOSISTEMA_OP_2 = "vdnMenuInformacionEcosistemaOP2";
	public static final String VAR_CONFIGURACION_FIELD_VDN_MENU_PRINCIPAL_OP_1 = "vdnMenuPrincipalOP1";
	public static final String VAR_CONFIGURACION_FIELD_VDN_MENU_PRINCIPAL_OP_2 = "vdnMenuPrincipalOP2";
	public static final String VAR_CONFIGURACION_FIELD_VDN_MENU_PRINCIPAL_OP_3 = "vdnMenuPrincipalOP3";
	public static final String VAR_CONFIGURACION_FIELD_VDN_MENU_PRINCIPAL_OP_8 = "vdnMenuPrincipalOP8";
	public static final String VAR_CONFIGURACION_FIELD_VDN_NO_INGRESA_DOCUMENTO = "vdnNoIngresaDocumento";
	public static final String PAC_DOCUMENTO_FIELD_CONFIDENCE = "confidence";
	public static final String PAC_DOCUMENTO_FIELD_INPUTMODE = "inputmode";
	public static final String PAC_DOCUMENTO_FIELD_INTERPRETATION = "interpretation";
	public static final String PAC_DOCUMENTO_FIELD_NOINPUTCOUNT = "noinputcount";
	public static final String PAC_DOCUMENTO_FIELD_NOMATCHCOUNT = "nomatchcount";
	public static final String PAC_DOCUMENTO_FIELD_UTTERANCE = "utterance";
	public static final String PAC_DOCUMENTO_FIELD_VALUE = "value";
	public static final String REDIRECTINFO_FIELD_PRESENTATIONINFO = "presentationinfo";
	public static final String REDIRECTINFO_FIELD_REASON = "reason";
	public static final String REDIRECTINFO_FIELD_SCREENINGINFO = "screeninginfo";
	public static final String REDIRECTINFO_FIELD_URI = "uri";
	public static final String MEN_INFORMACION_ECOSISTEMA_FIELD_CONFIDENCE = "confidence";
	public static final String MEN_INFORMACION_ECOSISTEMA_FIELD_INPUTMODE = "inputmode";
	public static final String MEN_INFORMACION_ECOSISTEMA_FIELD_INTERPRETATION = "interpretation";
	public static final String MEN_INFORMACION_ECOSISTEMA_FIELD_NOINPUTCOUNT = "noinputcount";
	public static final String MEN_INFORMACION_ECOSISTEMA_FIELD_NOMATCHCOUNT = "nomatchcount";
	public static final String MEN_INFORMACION_ECOSISTEMA_FIELD_UTTERANCE = "utterance";
	public static final String MEN_INFORMACION_ECOSISTEMA_FIELD_VALUE = "value";
	public static final String WEB_REQUEST_FIELD_ACCESS__TOKEN = "access_token";
	public static final String WEB_REQUEST_FIELD_ERROR_MESSAGE = "ErrorMessage";
	public static final String WEB_REQUEST_FIELD_IDCALL = "IDCall";
	public static final String WEB_REQUEST_FIELD_METHOD = "Method";
	public static final String WEB_REQUEST_FIELD_PARAMETERS = "Parameters";
	public static final String WEB_REQUEST_FIELD_RESPONSE = "Response";
	public static final String WEB_REQUEST_FIELD_TOKEN__TYPE = "token_type";
	public static final String WEB_REQUEST_FIELD_TRACE_REQUEST = "TraceRequest";
	public static final String WEB_REQUEST_FIELD_URL = "URL";
	public static final String REQUEST_REGISTER_CALL_FIELD_ANI = "ANI";
	public static final String REQUEST_REGISTER_CALL_FIELD_APPLICATION_ID = "ApplicationId";
	public static final String REQUEST_REGISTER_CALL_FIELD_APP_NAME = "AppName";
	public static final String REQUEST_REGISTER_CALL_FIELD_DNIS = "DNIS";
	public static final String REQUEST_REGISTER_CALL_FIELD_IP_WAS = "IpWas";
	public static final String REQUEST_REGISTER_CALL_FIELD_SESSION_ID = "SessionID";
	public static final String REQUEST_REGISTER_CALL_FIELD_UCID = "UCID";
	public static final String REQUEST_REGISTER_CALL_FIELD_UUI = "UUI";
	public static final String VARIABLES_VALIDAR_FIELD_DNIS_EXISTE = "dnisExiste";
	public static final String VARIABLES_VALIDAR_FIELD_DOCUMENTO = "documento";
	public static final String VARIABLES_VALIDAR_FIELD_PAIS = "pais";
	public static final String REQUEST_TPTOOLS_FIELD_TRANAPPLICATION_ID = "TRANApplicationId";
	public static final String DATE_FIELD_AUDIO = "audio";
	public static final String DATE_FIELD_DAYOFMONTH = "dayofmonth";
	public static final String DATE_FIELD_DAYOFWEEK = "dayofweek";
	public static final String DATE_FIELD_DAYOFWEEKNUM = "dayofweeknum";
	public static final String DATE_FIELD_DAYOFYEAR = "dayofyear";
	public static final String DATE_FIELD_MONTH = "month";
	public static final String DATE_FIELD_MONTHINYEAR = "monthinyear";
	public static final String DATE_FIELD_YEAR = "year";
	public static final String REQUEST_CONSULTA_CLIENTE_FIELD_UNIQUE_COD = "UniqueCod";
	public static final String MEN_FUERA_HORARIO_FIELD_CONFIDENCE = "confidence";
	public static final String MEN_FUERA_HORARIO_FIELD_INPUTMODE = "inputmode";
	public static final String MEN_FUERA_HORARIO_FIELD_INTERPRETATION = "interpretation";
	public static final String MEN_FUERA_HORARIO_FIELD_NOINPUTCOUNT = "noinputcount";
	public static final String MEN_FUERA_HORARIO_FIELD_NOMATCHCOUNT = "nomatchcount";
	public static final String MEN_FUERA_HORARIO_FIELD_UTTERANCE = "utterance";
	public static final String MEN_FUERA_HORARIO_FIELD_VALUE = "value";
	public static final String RESPONSE_TPTOOLS_FIELD_AUDIO_TEXT = "audioText";
	public static final String RESPONSE_TPTOOLS_FIELD_MESSAGE = "message";
	public static final String RESPONSE_TPTOOLS_FIELD_RESULT = "result";
	public static final String MEN_TIPO_DOCUMENTO_FIELD_CONFIDENCE = "confidence";
	public static final String MEN_TIPO_DOCUMENTO_FIELD_INPUTMODE = "inputmode";
	public static final String MEN_TIPO_DOCUMENTO_FIELD_INTERPRETATION = "interpretation";
	public static final String MEN_TIPO_DOCUMENTO_FIELD_NOINPUTCOUNT = "noinputcount";
	public static final String MEN_TIPO_DOCUMENTO_FIELD_NOMATCHCOUNT = "nomatchcount";
	public static final String MEN_TIPO_DOCUMENTO_FIELD_UTTERANCE = "utterance";
	public static final String MEN_TIPO_DOCUMENTO_FIELD_VALUE = "value";
	public static final String SESSION_FIELD_AAI = "aai";
	public static final String SESSION_FIELD_ANI = "ani";
	public static final String SESSION_FIELD_CALLTAG = "calltag";
	public static final String SESSION_FIELD_CHANNEL = "channel";
	public static final String SESSION_FIELD_CHANNELTYPE = "channeltype";
	public static final String SESSION_FIELD_CONVERSEFIRST = "conversefirst";
	public static final String SESSION_FIELD_CONVERSESECOND = "conversesecond";
	public static final String SESSION_FIELD_CURRENTLANGUAGE = "currentlanguage";
	public static final String SESSION_FIELD_DNIS = "dnis";
	public static final String SESSION_FIELD_EXIT_CUSTOMER_ID = "exitCustomerId";
	public static final String SESSION_FIELD_EXIT_INFO_1 = "exitInfo1";
	public static final String SESSION_FIELD_EXIT_INFO_2 = "exitInfo2";
	public static final String SESSION_FIELD_EXIT_PARENT_ID = "exitParentId";
	public static final String SESSION_FIELD_EXIT_PREFERRED_PATH = "exitPreferredPath";
	public static final String SESSION_FIELD_EXIT_REASON = "exitReason";
	public static final String SESSION_FIELD_EXIT_TOPIC = "exitTopic";
	public static final String SESSION_FIELD_LASTERROR = "lasterror";
	public static final String SESSION_FIELD_MEDIATYPE = "mediatype";
	public static final String SESSION_FIELD_PROTOCOLNAME = "protocolname";
	public static final String SESSION_FIELD_PROTOCOLVERSION = "protocolversion";
	public static final String SESSION_FIELD_SESSIONID = "sessionid";
	public static final String SESSION_FIELD_SESSIONLABEL = "sessionlabel";
	public static final String SESSION_FIELD_SHAREDMODE = "sharedmode";
	public static final String SESSION_FIELD_UCID = "ucid";
	public static final String SESSION_FIELD_UUI = "uui";
	public static final String SESSION_FIELD_VIDEOBITRATE = "videobitrate";
	public static final String SESSION_FIELD_VIDEOCODEC = "videocodec";
	public static final String SESSION_FIELD_VIDEOENABLED = "videoenabled";
	public static final String SESSION_FIELD_VIDEOFARFMTP = "videofarfmtp";
	public static final String SESSION_FIELD_VIDEOFORMAT = "videoformat";
	public static final String SESSION_FIELD_VIDEOFPS = "videofps";
	public static final String SESSION_FIELD_VIDEOHEIGHT = "videoheight";
	public static final String SESSION_FIELD_VIDEONEARFMTP = "videonearfmtp";
	public static final String SESSION_FIELD_VIDEOWIDTH = "videowidth";
	public static final String SESSION_FIELD_VPCALLEDEXTENSION = "vpcalledextension";
	public static final String SESSION_FIELD_VPCONVERSEONDATA = "vpconverseondata";
	public static final String SESSION_FIELD_VPCOVERAGEREASON = "vpcoveragereason";
	public static final String SESSION_FIELD_VPCOVERAGETYPE = "vpcoveragetype";
	public static final String SESSION_FIELD_VPRDNIS = "vprdnis";
	public static final String SESSION_FIELD_VPREPORTURL = "vpreporturl";
	public static final String INFO_LOG_CALL_FIELD_CALLID = "callid";
	public static final String DD_LAST_EXCEPTION_FIELD_ERRORCODE = "errorcode";
	public static final String DD_LAST_EXCEPTION_FIELD_MESSAGE = "message";
	public static final String DD_LAST_EXCEPTION_FIELD_OBJECT = "object";
	public static final String DD_LAST_EXCEPTION_FIELD_STACKTRACE = "stacktrace";
	public static final String DD_LAST_EXCEPTION_FIELD_TYPE = "type";
	public static final String TIME_FIELD_AUDIO = "audio";
	public static final String TIME_FIELD_HOUR = "hour";
	public static final String TIME_FIELD_MILLISECOND = "millisecond";
	public static final String TIME_FIELD_MINUTE = "minute";
	public static final String TIME_FIELD_SECOND = "second";
	public static final String TIME_FIELD_TIMEZONE = "timezone";
	public static final String SHAREDUUI_FIELD_ID = "id";
	public static final String SHAREDUUI_FIELD_VALUE = "value";
	//}}END:PROJECT:VARIABLEFIELDS
}
