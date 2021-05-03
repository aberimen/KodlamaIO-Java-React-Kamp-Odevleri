package serviceImpl;

import domain.Campaign;
import domain.Game;
import domain.Gamer;
import service.OrderService;

public class OrderManager implements OrderService{
	
	private Campaign campaign;
	
	public OrderManager() {
	}

	public OrderManager(Campaign campaign) {
		this.campaign = campaign;
	}

	@Override
	public void orderGame(Game game, Gamer gamer) {
		if(campaign != null) {
			double oyunFiyati = game.getPrice();
			double indirimOrani = campaign.getDiscountRate();
			double indirimliFiyat = oyunFiyati - (oyunFiyati*indirimOrani)/100;
			
			System.out.println("Kampanya uyguland�: " + campaign.getName());
			System.out.println("�ndirim oran�: %" + indirimOrani);
			System.out.println("Eski fiyat: " + oyunFiyati + "TL Indirimli fiyat: " + indirimliFiyat +"TL");
			
		}else {
			
			System.out.println("Kampanya mevcut de�il, normal fiyat �zerinden fiyatlan�r�ld�.");
		}
		
		System.out.println(game.getName() + " adl� oyun sat�n al�nd�- Kullan�c�: " + gamer.getFirstName());
	}


}
