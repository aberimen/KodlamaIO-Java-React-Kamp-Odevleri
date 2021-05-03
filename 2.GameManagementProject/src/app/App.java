package app;

import java.time.LocalDate;

import domain.Campaign;
import domain.Game;
import domain.Gamer;
import service.CampaignService;
import service.GamerService;
import service.OrderService;
import serviceImpl.CampaignManager;
import serviceImpl.GamerManager;
import serviceImpl.OrderManager;
import serviceImpl.UserValidatorWithEDevlet;

public class App {

	public static void main(String[] args) {
		Game[] games = { new Game("Gta V", 120), new Game("Fall Guys", 38) };
		System.out.println("Oyunlar:");
		for (Game game : games) {
			System.out.println(game.getName() + " " + game.getPrice() + "TL");
		}

		System.out.println("-------------------");

		Gamer gamer = new Gamer(1, "Abdurrahman", "Berimen", LocalDate.of(1997, 11, 11), "123456789");
		GamerService gameService = new GamerManager(new UserValidatorWithEDevlet());
		gameService.save(gamer);

		System.out.println("-------------------");

		Campaign campaign = new Campaign("Mayýs Sonu Özel", "Mayýs sonuna özel tüm oyunlarda %35 indirim", 35);
		CampaignService campaignService = new CampaignManager();
		campaignService.save(campaign);

		System.out.println("-------------------");

		OrderService orderService2 = new OrderManager(campaign);
		orderService2.orderGame(games[1], gamer);
		
		System.out.println("-------------------");
		
		OrderService orderService = new OrderManager();
		orderService.orderGame(games[0], gamer);

		
	}

}
