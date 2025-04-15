package service;

import dto.CajaDeAhorro;
import dto.Cuenta;
import dto.CuentaCorriente;
import java.util.List;
import java.util.ArrayList;

public final class LogicaCuenta {
    private static LogicaCuenta instance;
    private List<Cuenta> cuentas;
    public LogicaCuenta() {
        cuentas = new ArrayList<Cuenta>();
    }

    boolean agregarSaldo(int cuenta, double monto){
        Cuenta cuentaObj = cuentas.get(cuenta);
        boolean resultado;
        if (cuentaObj.getClass() == CajaDeAhorro.class){
            CajaDeAhorro cajaDeAhorro = (CajaDeAhorro) cuentaObj;
            resultado = cajaDeAhorro.agregarSaldo(monto);
            if(resultado){
            cuentas.removeIf(x->x.getId() == cuenta);
            cuentas.add(cajaDeAhorro);
            }
        }
        else{
            CuentaCorriente cuentaCorriente = (CuentaCorriente) cuentaObj;
            resultado = cuentaCorriente.agregarSaldo(monto);
            if(resultado) {
                cuentas.removeIf(x -> x.getId() == cuenta);
                cuentas.add(cuentaCorriente);
            }
        }
        return resultado;
    }

    boolean quitarSaldo(int cuenta, double monto){
        Cuenta cuentaObj = cuentas.get(cuenta);
        boolean resultado;
        if (cuentaObj.getClass() == CajaDeAhorro.class){
            CajaDeAhorro cajaDeAhorro = (CajaDeAhorro) cuentaObj;
            resultado = resultado = cajaDeAhorro.agregarSaldo(monto);
            if(resultado) {
                cuentas.removeIf(x -> x.getId() == cuenta);
                cuentas.add(cajaDeAhorro);
            }
        }
        else{
            CuentaCorriente cuentaCorriente = (CuentaCorriente) cuentaObj;
            resultado = cuentaCorriente.agregarSaldo(monto);
            if(resultado) {
                cuentas.removeIf(x -> x.getId() == cuenta);
                cuentas.add(cuentaCorriente);
            }
        }
        return resultado;
    }

    public double consultarSaldo(int cuenta){
        Cuenta cuentaObj = cuentas.get(cuenta);
        if (cuentaObj.getClass() == CajaDeAhorro.class){
            CajaDeAhorro cajaDeAhorro = (CajaDeAhorro) cuentaObj;
            return cajaDeAhorro.getSaldo();
        }
        else{
            CuentaCorriente cuentaCorriente = (CuentaCorriente) cuentaObj;
            return cuentaCorriente.getSaldo();
        }
    }

    public int consultarOperaciones (int cuenta){
        Cuenta cuentaObj = cuentas.get(cuenta);
        if (cuentaObj.getClass() == CajaDeAhorro.class){
            CajaDeAhorro cajaDeAhorro = (CajaDeAhorro) cuentaObj;
            return cajaDeAhorro.getOperaciones();
        }
        else{
            CuentaCorriente cuentaCorriente = (CuentaCorriente) cuentaObj;
            return cuentaCorriente.getOperaciones();
        }
    }

    public void agregarCuenta (Cuenta cuenta){
        cuentas.add(cuenta);
    }

}
