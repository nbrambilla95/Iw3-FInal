package iua.edu.ar.rest;

public final class Constantes {

	public static final String URL_API = "/api";
	public static final String URL_API_VERSION = "/v1";
	public static final String URL_BASE = URL_API + URL_API_VERSION;
	
	public static final String URL_REGISTRAR = URL_BASE + "/registrar";

	public static final String URL_LOGIN = URL_BASE + "/login";
	public static final String URL_AUTH = URL_LOGIN +"/auth-info";
	
	public static final String URL_PRODUCTOS = URL_BASE + "/productos";	
	public static final String URL_CAMIONES = URL_BASE + "/camiones";
	public static final String URL_CHOFERES = URL_BASE + "/choferes";
	public static final String URL_ORDENES = URL_BASE + "/ordenes";
	public static final String URL_ORDENES_DETALLES = URL_BASE + "/orden-detalle";

	
	public static final String URL_CLIENTES = URL_BASE + "/clientes";
	public static final String URL_SISTEMA_EXTERNO = URL_BASE + "/sistema-externo";
	



}