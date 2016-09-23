package game;


import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.GraphicApplication;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Resolution;
import com.senac.SimpleJava.Graphics.Sprite;
import com.senac.SimpleJava.Graphics.events.KeyboardAction;

public class Arkanoid extends GraphicApplication {

	private Bola bola;
	private Sprite paddel;
	private boolean  posPaddel = true 
					, desenhaBloco1 = true
					, desenhaBloco2 = true
					, desenhaBloco3 = true
					, desenhaBloco4 = true
					, desenhaBloco5 = true
					, desenhaBloco6 = true
					, desenhaBloco7 = true; 
	private Sprite bloco, bloco1, bloco2, bloco3, bloco4, bloco5, bloco6, bloco7;
	private int[] blocoA = new int[10];
	
	
	@Override
	protected void draw(Canvas canvas) {		
		canvas.clear();
		
		bola.draw(canvas);
		
		if(desenhaBloco1){
			bloco1.draw(canvas);
		}
		if(desenhaBloco2){
			bloco2.draw(canvas);
		}
		if(desenhaBloco3){
			bloco3.draw(canvas);
		}
		if(desenhaBloco4){
			bloco4.draw(canvas);
		}
		if(desenhaBloco5){
			bloco5.draw(canvas);
		}
		if(desenhaBloco6){
			bloco6.draw(canvas);
		}
		if(desenhaBloco7){
			bloco7.draw(canvas);
		}
		
		paddel.draw(canvas);
	}
	
	
	

	@Override
	protected void setup() {
		this.setTitle("Arkanoid");
		this.setResolution(Resolution.MSX);
		this.setFramesPerSecond(60);
		
		criarBlocos();	
		
		
		bola = new Bola();
		bola.setPosition(150, 150);
		
		paddel();

		
	}


	private void paddel() {
		paddel = new Sprite(20, 5, Color.RED);
		paddel.setPosition(Resolution.MSX.width/2 - 10, Resolution.MSX.height - 25);
		this.bindKeyPressed("LEFT", new KeyboardAction() {
			@Override
			public void handleEvent() {
				paddel.move(-3, 0);
			}
		});
		
		this.bindKeyPressed("RIGHT", new KeyboardAction() {
			@Override
			public void handleEvent() {
				paddel.move(+3, 0);
			}
		});
		
	}




	private void criarBlocos() {
		bloco1 = new Bloco();
		bloco1.setPosition(0, 50);
		
		bloco2 = new Bloco();
		bloco2.setPosition(19, 50);
		
		bloco3 = new Bloco();
		bloco3.setPosition(38, 50);
		
		bloco4 = new Bloco();
		bloco4.setPosition(57, 50);
		
		bloco5 = new Bloco();
		bloco5.setPosition(76, 50);
		
		bloco6 = new Bloco();
		bloco6.setPosition(95, 50);
		
		bloco7 = new Bloco();
		bloco7.setPosition(114, 50);
		
	}




	@Override
	protected void loop() {
		bola.move();
		
		
		
		verificarBloco1();
		verificarBloco2();
		verificarBloco3();
		verificarBloco4();
		verificarBloco5();
		verificarBloco6();
		verificarBloco7();
		
		
		}




	private void verificarBloco7() {
		Point posicao = bola.getPosition();
		
		if(posicao.y <= 0 || posicao.y >= Resolution.MSX.height-5){
			bola.direcaoY();
		}
		if(posicao.x <= 0 || posicao.x >= Resolution.MSX.width-5){
			bola.direcaoX();
		}
		
		boolean bateu = true;
		Point posicaoBloco = bloco7.getPosition();
		// Se qualquer teste for verdadeiro, a bola nao bateu no bloco.
		if (posicao.x > posicaoBloco.x + bloco7.getWidth()) 
		{
			bateu = false; 
		}
		if (posicao.x  + bola.getWidth() < posicaoBloco.x) 
		{
			bateu = false;
		}
		if (posicao.y > posicaoBloco.y + bloco7.getHeight()) 
		{
			bateu = false;
		}
		if (posicao.y  + bola.getHeight() < posicaoBloco.y) 
		{
			bateu = false;
		}
		
		if(desenhaBloco7 == bateu){
			bola.direcaoX();
			bola.direcaoY();
			redraw();
			
		}
		

		
	}
	private void verificarBloco6() {
		Point posicao = bola.getPosition();
		
		if(posicao.y <= 0 || posicao.y >= Resolution.MSX.height-5){
			bola.direcaoY();
		}
		if(posicao.x <= 0 || posicao.x >= Resolution.MSX.width-5){
			bola.direcaoX();
		}
		
		boolean bateu = true;
		Point posicaoBloco = bloco6.getPosition();
		// Se qualquer teste for verdadeiro, a bola nao bateu no bloco.
		if (posicao.x > posicaoBloco.x + bloco6.getWidth()) 
		{
			bateu = false; 
		}
		if (posicao.x  + bola.getWidth() < posicaoBloco.x) 
		{
			bateu = false;
		}
		if (posicao.y > posicaoBloco.y + bloco6.getHeight()) 
		{
			bateu = false;
		}
		if (posicao.y  + bola.getHeight() < posicaoBloco.y) 
		{
			bateu = false;
		}
		
		if(desenhaBloco6 = !bateu){
			bola.direcaoX();
			bola.direcaoY();
			redraw();
		}
		

		
	}
	private void verificarBloco5() {
		Point posicao = bola.getPosition();
		
		if(posicao.y <= 0 || posicao.y >= Resolution.MSX.height-5){
			bola.direcaoY();
		}
		if(posicao.x <= 0 || posicao.x >= Resolution.MSX.width-5){
			bola.direcaoX();
		}
		
		boolean bateu = true;
		Point posicaoBloco = bloco5.getPosition();
		// Se qualquer teste for verdadeiro, a bola nao bateu no bloco.
		if (posicao.x > posicaoBloco.x + bloco5.getWidth()) 
		{
			bateu = false; 
		}
		if (posicao.x  + bola.getWidth() < posicaoBloco.x) 
		{
			bateu = false;
		}
		if (posicao.y > posicaoBloco.y + bloco5.getHeight()) 
		{
			bateu = false;
		}
		if (posicao.y  + bola.getHeight() < posicaoBloco.y) 
		{
			bateu = false;
		}
		
		if(desenhaBloco5 = !bateu){
			bola.direcaoX();
			bola.direcaoY();
			redraw();
		}
	
	}
	private void verificarBloco4() {
		Point posicao = bola.getPosition();
		
		if(posicao.y <= 0 || posicao.y >= Resolution.MSX.height-5){
			bola.direcaoY();
		}
		if(posicao.x <= 0 || posicao.x >= Resolution.MSX.width-5){
			bola.direcaoX();
		}
		
		boolean bateu = true;
		Point posicaoBloco = bloco4.getPosition();
		// Se qualquer teste for verdadeiro, a bola nao bateu no bloco.
		if (posicao.x > posicaoBloco.x + bloco4.getWidth()) 
		{
			bateu = false; 
		}
		if (posicao.x  + bola.getWidth() < posicaoBloco.x) 
		{
			bateu = false;
		}
		if (posicao.y > posicaoBloco.y + bloco4.getHeight()) 
		{
			bateu = false;
		}
		if (posicao.y  + bola.getHeight() < posicaoBloco.y) 
		{
			bateu = false;
		}
		
		if(desenhaBloco4 = !bateu){
			bola.direcaoX();
			bola.direcaoY();
			redraw();
			
		}
		
	}
	private void verificarBloco3() {
		Point posicao = bola.getPosition();
		
		if(posicao.y <= 0 || posicao.y >= Resolution.MSX.height-5){
			bola.direcaoY();
		}
		if(posicao.x <= 0 || posicao.x >= Resolution.MSX.width-5){
			bola.direcaoX();
		}
		
		boolean bateu = true;
		Point posicaoBloco = bloco3.getPosition();
		// Se qualquer teste for verdadeiro, a bola nao bateu no bloco.
		if (posicao.x > posicaoBloco.x + bloco3.getWidth()) 
		{
			bateu = false; 
		}
		if (posicao.x  + bola.getWidth() < posicaoBloco.x) 
		{
			bateu = false;
		}
		if (posicao.y > posicaoBloco.y + bloco3.getHeight()) 
		{
			bateu = false;
		}
		if (posicao.y  + bola.getHeight() < posicaoBloco.y) 
		{
			bateu = false;
		}
		
		if(desenhaBloco3 = !bateu){
			bola.direcaoX();
			bola.direcaoY();
			redraw();
		}
		
	}
	private void verificarBloco2() {
		Point posicao = bola.getPosition();
		
		if(posicao.y <= 0 || posicao.y >= Resolution.MSX.height-5){
			bola.direcaoY();
		}
		if(posicao.x <= 0 || posicao.x >= Resolution.MSX.width-5){
			bola.direcaoX();
		}
		
		boolean bateu = true;
		Point posicaoBloco = bloco2.getPosition();
		// Se qualquer teste for verdadeiro, a bola nao bateu no bloco.
		if (posicao.x > posicaoBloco.x + bloco2.getWidth()) 
		{
			bateu = false; 
		}
		if (posicao.x  + bola.getWidth() < posicaoBloco.x) 
		{
			bateu = false;
		}
		if (posicao.y > posicaoBloco.y + bloco2.getHeight()) 
		{
			bateu = false;
		}
		if (posicao.y  + bola.getHeight() < posicaoBloco.y) 
		{
			bateu = false;
		}
		
		if(desenhaBloco2 = !bateu){
			bola.direcaoX();
			bola.direcaoY();
			redraw();
		}
		
	}
	private void verificarBloco1() {
		Point posicao = bola.getPosition();
		
		if(posicao.y <= 0 || posicao.y >= Resolution.MSX.height-5){
			bola.direcaoY();
		}
		if(posicao.x <= 0 || posicao.x >= Resolution.MSX.width-5){
			bola.direcaoX();
		}
		
		boolean bateu = true;
		Point posicaoBloco = bloco1.getPosition();
		// Se qualquer teste for verdadeiro, a bola nao bateu no bloco.
		if (posicao.x > posicaoBloco.x + bloco1.getWidth()) 
		{
			bateu = false; 
		}
		if (posicao.x  + bola.getWidth() < posicaoBloco.x) 
		{
			bateu = false;
		}
		if (posicao.y > posicaoBloco.y + bloco1.getHeight()) 
		{
			bateu = false;
		}
		if (posicao.y  + bola.getHeight() < posicaoBloco.y) 
		{
			bateu = false;
		}
		
		if(desenhaBloco1 = !bateu){
			bola.direcaoX();
			bola.direcaoY();
			redraw();
		}
	}

}

