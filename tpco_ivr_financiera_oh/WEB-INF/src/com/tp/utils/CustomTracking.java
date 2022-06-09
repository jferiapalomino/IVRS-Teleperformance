package com.tp.utils;

import com.avaya.sce.runtimecommon.IRuntimeSession;
import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;

public class CustomTracking {
	
	private CustomTracking() {
	}
	
	public static void info(SCESession mySession, String msg) {
		String status = "[".concat(Thread.currentThread().getStackTrace()[2].getClassName()).concat(" - ")
				.concat(Thread.currentThread().getStackTrace()[2].getMethodName()).concat(" - ")
				.concat(String.valueOf(Thread.currentThread().getStackTrace()[2].getLineNumber())).concat("] ").concat(msg);
		mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, status);
	}

	public static void debug(SCESession mySession, String msg) {
		String status = "[".concat(Thread.currentThread().getStackTrace()[2].getClassName()).concat(" - ")
				.concat(Thread.currentThread().getStackTrace()[2].getMethodName()).concat(" - ")
				.concat(String.valueOf(Thread.currentThread().getStackTrace()[2].getLineNumber())).concat("] ").concat(msg);
		mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, status);
	}

	public static void warn(SCESession mySession, String msg) {
		String status = "[".concat(Thread.currentThread().getStackTrace()[2].getClassName()).concat(" - ")
				.concat(Thread.currentThread().getStackTrace()[2].getMethodName()).concat(" - ")
				.concat(String.valueOf(Thread.currentThread().getStackTrace()[2].getLineNumber())).concat("] ").concat(msg);
		mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_WARN, status);
	}
	
	public static void error(SCESession mySession, String msg) {
		String status = "[".concat(Thread.currentThread().getStackTrace()[2].getClassName()).concat(" - ")
				.concat(Thread.currentThread().getStackTrace()[2].getMethodName()).concat(" - ")
				.concat(String.valueOf(Thread.currentThread().getStackTrace()[2].getLineNumber())).concat("] ").concat(msg);
		mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_ERROR, status);
	}

	public static void info(IRuntimeSession mySession, String msg) {
		String status = "[".concat(Thread.currentThread().getStackTrace()[2].getClassName()).concat(" - ")
				.concat(Thread.currentThread().getStackTrace()[2].getMethodName()).concat(" - ")
				.concat(String.valueOf(Thread.currentThread().getStackTrace()[2].getLineNumber())).concat("] ").concat(msg);
		mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_INFO, status);
	}

	public static void debug(IRuntimeSession mySession, String msg) {
		String status = "[".concat(Thread.currentThread().getStackTrace()[2].getClassName()).concat(" - ")
				.concat(Thread.currentThread().getStackTrace()[2].getMethodName()).concat(" - ")
				.concat(String.valueOf(Thread.currentThread().getStackTrace()[2].getLineNumber())).concat("] ").concat(msg);
		mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, status);
	}
	
	public static void error(IRuntimeSession mySession, String msg) {
		String status = "[".concat(Thread.currentThread().getStackTrace()[2].getClassName()).concat(" - ")
				.concat(Thread.currentThread().getStackTrace()[2].getMethodName()).concat(" - ")
				.concat(String.valueOf(Thread.currentThread().getStackTrace()[2].getLineNumber())).concat("] ").concat(msg);
		mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_ERROR, status);
	}
}
