package com.bscl.assignment.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/**
 * Message structure
 * @author vchitti
 *
 */
public class Message implements Comparable<Message>{

	@NotNull
	@Min(value = 1)
	@Max(value = 100)
	private Integer instructionType;
	
	@NotNull
	@Min(value = 1)
	private Integer productCode;
	
	@NotNull
	@Min(value = 1)
	private Integer quantity;
	
	@NotNull
	@Min(value = 0)
	@Max(value = 256)
	private Integer UOM;
	
	@NotNull
	@Min(value = 1)
	private Integer timestamp;

	public Message() {
	}
	
	public Message(final Integer instructionType, final Integer productCode,
			final Integer quantity, final Integer UOM, final Integer timestamp) {
		this.instructionType = instructionType;
		this.productCode = productCode;
		this.quantity = quantity;
		this.UOM = UOM;
		this.timestamp = timestamp;
	}
	
	public Integer getInstructionType() {
		return instructionType;
	}

	public void setInstructionType(Integer instructionType) {
		this.instructionType = instructionType;
	}

	public Integer getProductCode() {
		return productCode;
	}

	public void setProductCode(Integer productCode) {
		this.productCode = productCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getUOM() {
		return UOM;
	}

	public void setUOM(Integer uOM) {
		UOM = uOM;
	}

	public Integer getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((instructionType == null) ? 0 : instructionType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (instructionType == null) {
			if (other.instructionType != null)
				return false;
		} else if (!instructionType.equals(other.instructionType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [instructionType=" + instructionType + ", productCode="
				+ productCode + ", quantity=" + quantity + ", UOM=" + UOM
				+ ", timestamp=" + timestamp + "]";
	}

	public int compareTo(Message message) {
		return (int) (this.getInstructionType() - message.getInstructionType());
	}


}
