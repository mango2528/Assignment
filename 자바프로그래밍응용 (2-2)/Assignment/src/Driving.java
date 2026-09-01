public interface Driving {

}

interface PowerSource extends Driving {
	
	/** 가솔린, 디젤, 전기 */
	public String generatePowerSource();
}

interface MovingPower extends Driving {
	
	/** 엔진, 전기모터 */
	public String generatePowerType();
}

interface Feature extends Driving {
	
	/** Bucket, Bench, Split-Bench */
	public String generateSeating();
	
	/** Sedan : 13 ~ 17, SUV : 30 ~ 40 */
	public int generateCapacity();
	
	/** Sedan : 12 ~ 16, SUV : 30 ~ 145 */
	public int generateSize();
}
