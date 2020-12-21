package scripts;

import Accion.AccionMetodos;


public class ClienteNuevoCompra extends AccionMetodos {

	public ClienteNuevoCompra(){
	}

	public void compra(){
		abrirPagina("http://automationpractice.com/index.php");
		if (esperaObjetoDisponible("//*[@id=\"header_logo\"]/a/img")) {
			inspeccionarPagina(4);
			if (esperaObjetoDisponible("//*[@id=\"block_top_menu\"]/ul/li[3]")) {	
				darClick("//*[@id=\"block_top_menu\"]/ul/li[3]");
				inspeccionarPagina(3);
				if (esperaObjetoDisponible("//*[@id=\"block_top_menu\"]/ul/li[2]")) {
					darClick("//*[@id=\"block_top_menu\"]/ul/li[2]");
					inspeccionarPagina(4);	
					if (esperaObjetoDisponible("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]")) {
						darClick("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]");
						cambiarFrameDeterminado("/html/body/div[2]/div/div/div/div/iframe");
						if (esperaObjetoDisponible("//*[@id=\"add_to_cart\"]/button")) {
							darClick("//*[@id=\"add_to_cart\"]/button");
							if (esperaObjetoDisponible("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")) {
								darClick("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");
								if (esperaObjetoDisponible("//*[@id=\"center_column\"]/p[2]/a[1]")) {
									darClick("//*[@id=\"center_column\"]/p[2]/a[1]");
									if (esperaObjetoDisponible("//*[@id=\"email_create\"]")) {
										escribirEnObjeto("//*[@id=\"email_create\"]", "jeferson"+generarNumeroRandom(6)+"@gmail.co");	
										darClick("//*[@id=\"SubmitCreate\"]");
										if (esperaObjetoDisponible("//*[@id=\"id_gender1\"]")) {
											darClick("//*[@id=\\\"id_gender1\\\"]");

											escribirEnObjeto("//*[@id=\"customer_firstname\"]", "jeferson");	
											escribirEnObjeto("//*[@id=\"customer_lastname\"]", "Pedraza");
											escribirEnObjeto("//*[@id=\"passwd\"]", "Temporal123*");
											escribirEnObjeto("//*[@id=\"passwd\"]", "Temporal123*");
											opcionSelect("//*[@id=\"days\"]");
											opcionSelect("//*[@id=\"months\"]");
											opcionSelect("//*[@id=\"years\"]");
											escribirEnObjeto("//*[@id=\"company\"]", "Colombia SA");
											escribirEnObjeto("//*[@id=\"address1\"]", "Calle 13 #15-30");
											escribirEnObjeto("//*[@id=\"city\"]", "Bogota");
											opcionSelect("//*[@id=\"id_state\"]");
											escribirEnObjeto("//*[@id=\"postcode\"]", "00000");
											opcionSelect("//*[@id=\"id_country\"]");
											escribirEnObjeto("//*[@id=\"other\"]", "Prueba plantilla");
											escribirEnObjeto("//*[@id=\"phone\"]", "322795032");
											escribirEnObjeto("//*[@id=\"phone_mobile\"]", "322795032");

											darClick("//*[@id=\"submitAccount\"]");

											if (esperaObjetoDisponible("//*[@id=\"center_column\"]/form/p/button")) {
												darClick("//*[@id=\"center_column\"]/form/p/button");
												if (esperaObjetoDisponible("//*[@id=\"form\"]/p/button")) {
													darClick("//*[@id=\"cgv\"]");
													darClick("//*[@id=\"form\"]/p/button");
													if (esperaObjetoDisponible("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p")) {
														darClick("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p");
														if (esperaObjetoDisponible("//*[@id=\"cart_navigation\"]/button")) {
															darClick("//*[@id=\"cart_navigation\"]/button");
															
															System.out.println("Venta exitosaaaaa!!");
														}
													}													
												}
											}

										}
									}
								}
							}else {
								System.out.println("No se encuentra el boton Proceed to checkout");
							}
						}else {
							System.out.println("No se encuentra el boton add to cart");
						}
					}else {
						System.out.println("No se selecciona ningun producto");
					}
				}else {
					System.out.println("No se encuentra el objeto Dresses");
				}

			}else {
				System.out.println("No se encuentra el objeto T-shirts");
			}
		}else {
			System.out.println("La pagina no carga correctamente");
		}

	}
}
