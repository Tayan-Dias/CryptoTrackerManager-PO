
package po23s.model;

import java.util.ArrayList;
import org.json.JSONObject;
import po23s.http.ClienteHttp;

/**
 *
 * @author Cliente
 */
public class Cripto {
    String nome;
    String compra;
    String venda;

    public Cripto(String nome, String compra, String venda) {
        this.nome = nome;
        this.compra = compra;
        this.venda = venda;
    }

    public Cripto() {
    }

    public String getNome() {
        return nome;
    }

    public String getCompra() {
        return compra;
    }

    public String getVenda() {
        return venda;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCompra(String compra) {
        this.compra = compra;
    }

    public void setVenda(String venda) {
        this.venda = venda;
    }

    public String buscaDados(String url) {
        ClienteHttp cliente = new ClienteHttp();
        String resultado = cliente.buscaDados(url);
        return resultado;
    }

    public void coverteJson(String resultado) {
        JSONObject obj = new JSONObject(resultado);
        setCompra(obj.getJSONObject("ticker").getString("buy"));
        setVenda(obj.getJSONObject("ticker").getString("sell"));
    }

    public String configURL(String nome) {
        String url = "https://www.mercadobitcoin.net/api/ETH/ticker";
        url = url.replaceAll("ETH", nome);
        return url;
    }

}
