

/**
 *
 * @author Eliazar Alonso Santana
 */
public class TarjetaDeCredito {

    private String entidadBancaria;
    private String nroTarjeta;
    private double saldo;
    private EntidadFinanciera entidadFinanciera;
    private Persona titular;

    /**
     *
     * @param entidadBancaria
     * @param nroTarjeta
     * @param saldo
     * @param titular
     * @param entidadFinanciera
     */
    public TarjetaDeCredito(String entidadBancaria, String nroTarjeta, double saldo, Persona titular, EntidadFinanciera entidadFinanciera) {
        this.entidadBancaria = entidadBancaria;
        this.nroTarjeta = nroTarjeta;
        this.saldo = saldo;
        this.titular = titular;
        this.entidadFinanciera = entidadFinanciera;
    }

    /**
     *
     * @param monto
     * @return boolean si tiene saldo disponible
     */
    public boolean tieneSaldoDisponible(double monto) {
        return saldo >= monto;
    }

    /**
     * dado el monto establecido se le descuenta esa cantidad al saldo
     * @param monto
     */
    public void descontar(double monto) {
        saldo = saldo - monto;
        // saldo -= monto;
    }

    /**
     *
     * @return string nombre completo
     */
    public String nombreCompletoDeTitular() {
        return titular.nombreCompleto();
    }

    /**
     *
     * @return string todos
     */
    @Override
    public String toString() {
        return "TarjetaDeCredito{" + "entidadBancaria=" + entidadBancaria + ", nroTarjeta=" + nroTarjeta + ", saldo=" + saldo + ", entidadFinanciera=" + entidadFinanciera + ", titular=" + titular + '}';
    }

}
