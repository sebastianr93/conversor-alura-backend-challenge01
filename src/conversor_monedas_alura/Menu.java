package conversor_monedas_alura;

import javax.swing.JOptionPane;

public class Menu {

	PesoADivisas divisas = new PesoADivisas();
	DivisasAPeso pesos = new DivisasAPeso();
	
    public void PesoADivisas(double Minput) {
    	String opcion = (JOptionPane.showInputDialog(null, 
    			"Elije la moneda a la que deseas convertir tu dinero ", "Monedas", 
    			JOptionPane.PLAIN_MESSAGE, null, new Object[] 
    			{"De Pesos a Dólar", "De Pesos a Euro", "De Pesos a Libras","De Pesos a Yen","De Pesos a Won Coreano","De Dólar a Pesos", "De Euro a Pesos", "De Libras a Pesos","De Yen a Pesos","De Won Coreano a Pesos"}, 
    			"Seleccion")).toString();
        switch(opcion) {
        case "De Pesos a Dólar":
        	divisas.pesoADolar(Minput);
        	break;
        case "De Pesos a Euro":
        	divisas.pesoAEuro(Minput);
        	break;
        case "De Pesos a Libras":
        	divisas.pesoALibra(Minput);
        	break;
        case "De Pesos a Yen":
        	divisas.pesoAYen(Minput);
        	break;
        case "De Pesos a Won Coreano":
        	divisas.pesoAWon(Minput);
        	break;    	    	                          
        case "De Dólar a Pesos":
        	pesos.dolarAPeso(Minput);
        	break;
        case "De Euro a Pesos":
        	pesos.euroAPeso(Minput);
        	break;
        case "De Libras a Pesos":
        	pesos.libraAPeso(Minput);
        	break;
        case "De Yen a Pesos":
        	pesos.yenAPeso(Minput);
        	break;
        case "De Won Coreano a Pesos":
            pesos.wonAPeso(Minput);
            break;
        }      
    }
        
}