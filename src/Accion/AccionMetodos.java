package Accion;

import metodos.MetodosProcesos;

public  class AccionMetodos {
	public static boolean abrirPagina(String pagina) {
		return	MetodosProcesos.getInstanciaUnicaMetodosProcesos().abrirPagina(pagina);
	}
	public boolean esperaObjetoDisponible(String xpath) {
		return	MetodosProcesos.getInstanciaUnicaMetodosProcesos().esperaObjetoDisponible(xpath);
	}
	
	public void inspeccionarPagina(int intentos) {
		MetodosProcesos.getInstanciaUnicaMetodosProcesos().inspeccionarPagina(intentos);
	}
	public boolean darClick(String elemento) {
		return	MetodosProcesos.getInstanciaUnicaMetodosProcesos().darClick(elemento);
	}
	public void cambiarFrameDeterminado(String frame){
		MetodosProcesos.getInstanciaUnicaMetodosProcesos().cambiarFrameDeterminado(frame);
	}
	public boolean escribirEnObjeto(String elemento,String texto) {
		return	MetodosProcesos.getInstanciaUnicaMetodosProcesos().escribirEnObjeto(elemento, texto);
	}
	
	public String generarNumeroRandom(int cantidadDitito){
		return	MetodosProcesos.getInstanciaUnicaMetodosProcesos().generarNumeroRandom(cantidadDitito);
	}
	
	public void opcionSelect(String xpath) {
		MetodosProcesos.getInstanciaUnicaMetodosProcesos().opcionSelect(xpath);
	}
}
