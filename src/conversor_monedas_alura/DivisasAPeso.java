package conversor_monedas_alura;


import javax.swing.JOptionPane;

public class DivisasAPeso {
	public void dolarAPeso(double valor) {
		double dolar = valor * 273.01;
		dolar = (double) Math.round(dolar *100d)/100;
        JOptionPane.showMessageDialog(null, "$" + dolar + " Pesos Argentinos");
	}
	
	public void euroAPeso(double valor) {
		double euro = valor * 299.72;
		euro = (double) Math.round(euro *100d)/100;
		JOptionPane.showMessageDialog(null, "$" + euro + " Pesos Argentinos");
	}
	
	public void libraAPeso(double valor) {
		double libra = valor * 349.36;
		libra = (double) Math.round(libra *100d)/100;
        JOptionPane.showMessageDialog(null, "$" + libra + " Pesos Argentinos");
	}
	
	public void yenAPeso(double valor) {
		double yen = valor * 1.96;
		yen = (double) Math.round(yen *100d)/100;
        JOptionPane.showMessageDialog(null, "$" + yen + " Pesos Argentinos");
	}
	
	public void wonAPeso(double valor) {
		double won = valor * 0.21;
		won = (double) Math.round(won *100d)/100;
        JOptionPane.showMessageDialog(null, "$" + won + " Pesos Argentinos");
	}
}
