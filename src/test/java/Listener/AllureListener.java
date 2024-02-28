package Listener;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.ITestListener;

public class AllureListener implements ITestListener {

    //Se muestra antes de la ejecución del primer test (Inicio de la prueba automatizada)
    public void onStart (ITestContext arg){
        System.out.println("Iniciando la Prueba Automatizada .......... "+arg.getName());
    }

    //Se muestra después de la ejecución del último test (Final de la prueba automatizada)
    public void onFinish (ITestContext arg){
        System.out.println("Finalizando la Prueba Automatizada .......... "+arg.getName());
    }

    //Se muestra cuando se empieza cada uno de los test
    public void onTestStart (ITestResult arg){
        System.out.println("Empezando la ejecucion del Test con Nombre .......... "+arg.getName());
    }

    //Se muestra cuando se Omite un Test
    public void onTestSkipped (ITestResult arg){
        System.out.println("Omitiendo la ejecucion del Test con Nombre .......... "+arg.getName());
    }

    //Se muestra cuando Finaliza de forma exitosa un Test
    public void onTestSuccess (ITestResult arg){
        System.out.println("Prueba Exitosa del Test con Nombre .......... "+arg.getName());
    }

    //Se muestra cuando Finaliza de forma fallida un Test
    public void onTestFailure (ITestResult arg){
        System.out.println("Prueba Fallida del Test con Nombre .......... "+arg.getName());
    }

}
