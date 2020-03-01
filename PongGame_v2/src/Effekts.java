
public class Effekts {
	int e;
	int et;
	Player p;
	Effekts(int e ,int et,Player p){
		
		this.e=e;
		this.et=et;
		this.p=p;
		
	}
	void make(){
		if(e==1) {
			p.bl=p.bl*2;
			
		}
		if(e==2) {
			p.bl=p.bl/2;
			
		}
		if(e==3) {
			p.bv=p.bv*1.5;
			
		}
		if(e==4) {
			p.bv=p.bv/3;
		}
		
	}
	void reverse(){
		if(e==1) {
			p.bl=p.bl/2;
			
		}
		if(e==2) {
			p.bl=p.bl*2;
			
		}
		if(e==3) {
			p.bv=p.bv/1.5;
			
		}
		if(e==4) {
			p.bv=p.bv*3;
		}
		
	}

}
