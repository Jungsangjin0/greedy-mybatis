package com.kh.section03.remix;

import java.util.List;
import java.util.Map;


public class MenuController {

	private final PrintResult printResult;
	private final MenuService menuService;
	
	public  MenuController() {
		printResult = new PrintResult();
		menuService = new MenuService();
	}
	
	public void selectAllMenu() {
		List<MenuDTO> menuList = menuService.selectAllMenu();
		
		if(menuList != null) {
			printResult.printMenuList(menuList);
		}else {
			printResult.printErrorMessage("selectList");
		}
		
	}

	public void selectMenuByCode(Map<String, String> inputMenuCode) {
		// TODO Auto-generated method stub
		
	}

	public void registMenu(Map<String, String> inputMenu) {
		// TODO Auto-generated method stub
		
	}

	public void modifyMenu(Map<String, String> inputModifyMenu) {
		// TODO Auto-generated method stub
		
	}

	public void deleteMenu(Map<String, String> inputMenuCode) {
		// TODO Auto-generated method stub
		
	}

}
