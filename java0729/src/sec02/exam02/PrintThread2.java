package sec02.exam02;

public class PrintThread2 extends Thread{
	
	@Override
	public void run() {
			while(true) {
				System.out.println("실행 중");
				if(Thread.interrupted()) {
					break;
				}
			}
		
		
		System.out.println("자원 정리");
		System.out.println("실행 정리");
	
	}
}
	
//	@Override
//	public void run() {
//		try {
//			while(true) {
//				System.out.println("실행 중");
//				Thread.sleep(1);
//			}
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//		}
//		
//		System.out.println("자원 정리");
//		System.out.println("실행 정리");
//	
//	}

