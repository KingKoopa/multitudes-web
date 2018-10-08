package cl.cleardigital.web.multitudes.dto.fichas;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@SuppressWarnings("serial")
@JsonInclude(Include.NON_NULL)
public class SujetoActivoLicitacionesDTO implements Serializable{
	
	private String tipo;
	private String descripcion;
	private Integer cantidad;
	private Integer monto;
	
	
	public String getDescripcion() {
		switch (this.tipo) {
		case "L1":
			this.descripcion = "Licitación Pública Menor a 100 UTM";
			break;
		case "LE":
			this.descripcion = "Licitación Pública Entre 100 y 1000 UTM";
			break;
		case "LQ":
			this.descripcion = "Licitación Pública entre a 2000 y 5000 UTM";
			break;
		case "LP":
			this.descripcion = "Licitación Pública Mayor 1000 UTM";
			break;
		case "LS":
			this.descripcion = "Licitación Pública Servicios personales especializados";
			break;
		case "A1":
			this.descripcion = "Licitación Privada por Licitación Pública anterior sin oferentes";
			break;
		case "B1":
			this.descripcion = "Licitación Privada por Remanente de Contrato anterior";
			break;
		case "E1":
			this.descripcion = "Licitación Privada por Convenios con Personas Jurídicas Extranjeras fuera del Territorio Nacional";
			break;
		case "F1":
			this.descripcion = "Licitación Privada por Servicios de Naturaleza Confidencial";
			break;
		case "J1":
			this.descripcion = "Licitación Privada por otras causales, excluidas de la ley de Compras";
			break;
		case "CO":
			this.descripcion = "Licitación Privada entre 100 y 1000 UTM";
			break;
		case "B2":
			this.descripcion = "Licitación Privada Mayor a 1000 UTM";
			break;
		case "A2":
			this.descripcion = "Trato Directo por Producto de Licitación Privada anterior sin oferentes o desierta";
			break;
		case "D1":
			this.descripcion = "Trato Directo por Proveedor Único";
			break;
		case "E2":
			this.descripcion = "Licitación Privada Menor a 100 UTM";
			break;
		case "C2":
			this.descripcion = "Trato Directo (Cotización)";
			break;
		case "C1":
			this.descripcion = "Compra Directa (Orden de compra)";
			break;
		case "F2":
			this.descripcion = "Trato Directo (Cotización)";
			break;
		case "F3":
			this.descripcion = "Compra Directa (Orden de compra)";
			break;
		case "G2":
			this.descripcion = "Directo (Cotización)";
			break;
		case "G1":
			this.descripcion = "Compra Directa (Orden de compra)";
			break;
		case "R1":
			this.descripcion = "Orden de Compra menor a 3 UTM";
			break;
		case "CA":
			this.descripcion = "Orden de Compra sin Resolución";
			break;
		case "SE":
			this.descripcion = "Orden de Compra proveniente de adquisición sin emisión automática de OC";
			break;
		case "O1":
			this.descripcion = "Licitación Pública MOP";
			break;
		case "LR":
			this.descripcion = "Licitación Pública Mayor a 5000";
			break;
		default:
			break;
		}
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getTipo() 
	{
		return tipo;
	}
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) 
	{
		this.cantidad = cantidad;
	}
	public Integer getMonto() 
	{
		return monto;
	}
	public void setMonto(Integer monto)
	{
		this.monto = monto;
	}
	
	@Override
	public String toString() {
		return "SujetoActivoLicitacionesDTO [Tipo=" + tipo + ", cantidad=" + cantidad + ", Monto=" + monto + "]";
	}
	
	

}
