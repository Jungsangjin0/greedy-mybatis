package com.kh.section01.xmlconfig;

import java.util.List;
import java.util.Map;

public class MenuController {
	
	private final PrintResult printResult;
	private final MenuService menuService;
	
	public MenuController() {
		printResult = new PrintResult();
		menuService = new MenuService();
	}
	
	/* 모든 메뉴 조회용 메소드 */
	public void selectAllMenu() {
		
		List<MenuDTO> menuList = menuService.selectAllMenu();
		
		if(menuList != null) {
			printResult.printMenuList(menuList);
		} else {
			printResult.printErrorMessage("selectList");
		}
		
	}
	
	/* 메뉴 코드로 메뉴 조회용 메소드 */
	public void selectMenuByCode(Map<String, String> parameter) {
		
		int code = Integer.parseInt(parameter.get("code"));
		
		MenuDTO menu = menuService.selectMenuByCode(code);
		
		if(menu != null) {
			printResult.printMenu(menu);
		} else {
			printResult.printErrorMessage("selectOne");
		}
		
	}
	
	/* 신규 메뉴 등록용 메소드 */
	public void registMenu(Map<String, String> parameter) {
		
		String name = parameter.get("name");
		int price = Integer.parseInt(parameter.get("price"));
		int categoryCode = Integer.parseInt(parameter.get("categoryCode"));
		
		MenuDTO menu = new MenuDTO();
		menu.setName(name);
		menu.setPrice(price);
		menu.setCategoryCode(categoryCode);
		
		if(menuService.registMenu(menu)) {
			printResult.printSuccessMessage("insert");
		} else {
			printResult.printErrorMessage("insert");
		}
		
	}
	
	/* 메뉴 수정용 메소드 */
	public void modifyMenu(Map<String, String> inputModifyMenu) {
		
	}
	
	/* 메뉴 삭제용 메소드 */
	public void deleteMenu(Map<String, String> inputMenuCode) {
		
	}

}
