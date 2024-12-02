package model;

public class HealthCheckLogic {
	//field
	//constructor

	
	//method				引数にインスタンスを使用！
	public void execute(Health health) {
		double weight = health.getWeight();
		double height = health.getHeight();  // /100するのもあり。
		double bmi = weight /(height / 100.0 * height / 100.0);
		
		//double bmi = weigth / Math.pow(height , 2);
									//    ↑基数　↑指数
		health.setBmi(bmi);
		
		String bodyType;
		if(bmi < 18.5) {
			bodyType = "やせ型";
		}else if (bmi < 25) {
			bodyType = "普通";
		}else {
			bodyType = "肥満";
		}
		//bodyType = bmi < 18.5 ? "やせ型" : bmi < 25 ? "普通":"肥満";
		
		health.setBodyType(bodyType);
	}
}
