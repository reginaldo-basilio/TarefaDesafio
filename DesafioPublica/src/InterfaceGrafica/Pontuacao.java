package InterfaceGrafica;

public class Pontuacao {

		private int minTemp;
		private int maxTemp;
		private int recMin;
		private int recMax;
		private Jogo jogo;
		
		public Pontuacao() {
			
		}

		public Pontuacao(Jogo jogo, int minTemp, int maxTemp, int recMin, int recMax) {
			this.jogo = jogo;
			this.minTemp = minTemp;
			this.maxTemp = maxTemp;
			this.recMin = recMin;
			this.recMax = recMax;
			
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

		public Jogo getJogo() {
			return jogo;
		}

		public void setJogo(Jogo jogo) {
			this.jogo = jogo;
		}
		
		public void preencherTabela(int placar) {
			
		}
		
	}


