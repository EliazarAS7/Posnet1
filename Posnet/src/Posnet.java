

/**
 *
 * @author Eliazar Alonso Santana
 */
public class Posnet {

    public static final double RECARGO_POR_CUOTA = 0.03;
    public static final int MIN_CANT_CUOTAS = 1;
    public static final int MAX_CANT_CUOTAS = 6;

    /**
     *
     * @param tarjeta
     * @param montoAAbonar
     * @param cantCuotas
     * @return
     */
    public Ticket efectuarPago(TarjetaDeCredito tarjeta, double montoAAbonar, int cantCuotas) {
        Ticket elTicket = null;

        if (datosValidos(tarjeta, montoAAbonar, cantCuotas)) {
            double montoFinal = montoAAbonar + montoAAbonar * recargoSegunCuotas(cantCuotas);
            if (tarjeta.tieneSaldoDisponible(montoFinal)) {
                tarjeta.descontar(montoFinal);
                String nomApe = tarjeta.nombreCompletoDeTitular();
                double montoPorCuota = montoFinal / cantCuotas;
                elTicket = new Ticket(nomApe, montoFinal, montoPorCuota);
            }
        }

        return elTicket;
    }

    /**
     *
     * @param tarjeta
     * @param monto
     * @param cant
     * @return boolean comprobar si la terjeta es valida
     */
    private boolean datosValidos(TarjetaDeCredito tarjeta, double monto, int cant) {
        boolean esTarjetaValida = tarjeta != null;
        boolean esMontoValido = monto > 0;
        boolean cantCuotasValidas = cant >= MIN_CANT_CUOTAS && cant <= MAX_CANT_CUOTAS;

        return esTarjetaValida && esMontoValido && cantCuotasValidas;
    }

    /**
     *
     * @param cantCuotas
     * @return double se calcula el recrago por cuotas
     */
    private double recargoSegunCuotas(int cantCuotas) {
        return (cantCuotas - 1) * RECARGO_POR_CUOTA;
    }

}
