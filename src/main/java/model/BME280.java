package model;


import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "BME280")
public class BME280 {
	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIME_STAMP")
    private Long timeStamp;
	@Column(name = "TEMPERATURE")
	private Integer temperature;//C
	@Column(name = "PRESSURE")
	private Integer pressure;//mmHg
	@Column(name = "HUMIDITY")
	private Integer humidity;//%
	
	public BME280(Integer temperature, Integer pressure, Integer humidity) {
		timeStamp=System.currentTimeMillis();
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
	}
	
	
}
