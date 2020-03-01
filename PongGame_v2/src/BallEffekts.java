
public class BallEffekts {
	int e;
	int et;
	Ball b;
	BallEffekts(int e ,int et,Ball b){
		
		this.e=e;
		this.et=et;
		this.b=b;
		
	}
	void make() {
		if(e==1) {	
			b.size/=2;
		}
		if(e==2) {
			b.size*=2;
		}
		if(e==3) {
			b.v*=2;
			
		}
		if(e==5) {
			b.r=0;
			b.g=0;
			b.b=0;
		}
	}
	void reverse() {
		if(e==1) {	
			b.size*=2;
		}
		if(e==2) {
			b.size/=2;
		}
		if(e==3) {
			b.v/=2;
			
		}
		if(e==5) {
			b.r=255;
			b.g=255;
			b.b=255;
		}
	}

}
