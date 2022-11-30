
public class main {
    public static void main(String[] args){
        Window masterWindow = new Window();
        System.out.println(InventarioSyO.listaInventario().get(0).toString());
        Afiliado.actualizarNipTarjeta("Afiliados", "Nip", "123458", 22);
    }
}
