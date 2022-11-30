
public class main {
    public static void main(String[] args){
        Window masterWindow = new Window();
        Cliente.actualizarFechas("Clientes", "Fecha de Nacimiento", "2022-10-02", 21);
        Object[][] prueba = (Object[][]) masterWindow.createMatrixList();
        System.out.println(prueba[0][1]);
        //Prueba
    }
}
