package InterfaceGrafica;

public class Pontuacao {

		private int id;
		private int placar;
		private int minTemp = 1000;
		private int maxTemp = 0;
		private int recMin = 0;
		private int recMax = 0;
		
		public Pontuacao() {
			
		}
		
		public Pontuacao(int placar) {
			this.placar = placar;
		}

		public Pontuacao(int placar, int minTemp, int maxTemp, int recMin, int recMax) {
			this.placar = placar;
			this.minTemp = minTemp;
			this.maxTemp = maxTemp;
			this.recMin = recMin;
			this.recMax = recMax;			
		}

		public int getPlacar() {
			return placar;
		}

		public void setPlacar(int placar) {
			this.placar = placar;
		}
		
		public int getMinTemp() {
			return minTemp;
		}

		public void setMinTemp(int minTemp) {
			this.minTemp = minTemp;
		}

		public int getMaxTemp() {
			return maxTemp;
		}

		public void setMaxTemp(int maxTemp) {
			this.maxTemp = maxTemp;
		}

		public int getRecMin() {
			return recMin;
		}

		public void setRecMin(int recMin) {
			this.recMin = recMin;
		}

		public int getRecMax() {
			return recMax;
		}

		public void setRecMax(int recMax) {
			this.recMax = recMax;
		}

		
		public void preencherTabela(int placar) {			
			if(placar < minTemp) {
				minTemp = placar;
			}
			if(placar >= maxTemp) {
				maxTemp = placar;
			}
			if(placar ) {
				
			}
		}
		
	}


