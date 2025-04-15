package modelo;

/**
 * Cliente Premium con descuento fijo en el envío y cuota anual.
 */
public class ClientePremium extends Cliente {
  private int cuotaAnual;

  public ClientePremium(String nombre, String domicilio, String nif, String email, int cuotaAnual) {
    super(nombre, domicilio, nif, email);
    this.cuotaAnual = cuotaAnual;
  }

  public int getCuotaAnual() {
    return cuotaAnual;
  }

  public void setCuotaAnual(int cuotaAnual) {
    this.cuotaAnual = cuotaAnual;
  }

  @Override
  public float descuentoEnvio() {

    return 0.20f;
  }
}
