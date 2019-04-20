package com.mycom.order;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.basket.BasketModel;
import com.mycom.basket.BasketService;
import com.mycom.goods.GoodsModel;
import com.mycom.goods.GoodsService;
import com.mycom.member.MemberModel;
import com.mycom.member.MemberService;
import com.mycom.member.ZipcodeModel;

@Controller
@RequestMapping("/order")
public class OrderComntroller {
	
	@Resource(name="goodsService")
	private GoodsService goodsService;
	
	@Resource(name="orderService")
	private OrderService orderService;
	
	 @Resource(name="memberService")
	 private MemberService memberService;
	 
	 @Resource(name="basketService")
	 private BasketService basketService;
	   
	 ModelAndView mav = new ModelAndView();
	 MemberModel memberModel = new MemberModel();
	 OrderModel orderModel = new OrderModel();
	 OrderModel orderModel2 = new OrderModel();
	 GoodsModel goodsModel = new GoodsModel();
	 private List<ZipcodeModel> zipcodeList = new ArrayList<ZipcodeModel>();
	 private List<OrderModel> orderList = new ArrayList<OrderModel>();
	 private List<BasketModel> basketList = new ArrayList<BasketModel>(); 
	 
	 //�ֹ� ��
	 @RequestMapping(value="/orderForm.dog")
	 public ModelAndView orderForm(HttpServletRequest request, GoodsModel goodsModel, HttpSession session ){
		 
		 session = request.getSession();
		 
		 int goods_num = goodsModel.getGoods_num();
		 int amount = goodsModel.getGoods_amount();
		 String id = request.getParameter("basket_member_id");
		 
		 if(id != ""){
			 goodsModel = goodsService.goodsView(goods_num);
			 memberModel = memberService.getMember(id);
			 goodsModel.setGoods_amount(amount);
			 mav.addObject("goodsModel", goodsModel);
			 mav.addObject("memberModel", memberModel);
			 mav.setViewName("orderForm");
			 
			 return mav;
			 
		 }else{
			 mav.setViewName("basket/basketAddError");
			 
			 return mav;
		 }
	 }
	 
	 //�����ȣã�� ��
	 @RequestMapping(value="/zipcodeCheckForm.dog")
     public ModelAndView zipcodeCheckForm( HttpServletRequest req) throws Exception{
		 	
		 	ModelAndView mv = new ModelAndView();
            mv.setViewName("check/zipcodeCheck2");
         return mv;
  }
        /*�ֹ��� �����ȣ �˻� ����*/ 
        @RequestMapping(value="/zipcodeCheck.dog")
        public ModelAndView zipcodeCheck( @ModelAttribute ZipcodeModel zipcodeModel ,HttpServletRequest req) throws Exception{
           ModelAndView mv = new ModelAndView();
           int chk=100;
           
            zipcodeList = memberService.zipcodeCheck(zipcodeModel);
            mv.addObject("zipcode", zipcodeList);
               if(zipcodeList.size() == 0){
                  chk =0;
               }else{
                  chk=1;
               }
            mv.addObject("chk",chk);
            mv.setViewName("check/zipcodeCheck2");
            return mv;
         }   
	
        
        //1�� �ֹ� �ֱ�
        @RequestMapping(value="/orderForm1.dog")
   	 	public ModelAndView orderInsert(HttpServletRequest request, GoodsModel goodsModel, HttpSession session, OrderModel orderModel,MemberModel memberModel ){
   		 
   		 session = request.getSession();
   		 
   		 int goods_num = goodsModel.getGoods_num();
   		 int amount = goodsModel.getGoods_amount();
   		 String id = (String)session.getAttribute("session_member_id");
   		 
   		 
   		 orderModel.setOrder_goods_num(goods_num);
   		 orderModel.setOrder_goods_amount(amount);
   		 orderModel.setOrder_member_id(id);
   		 orderModel.setOrder_receive_zipcode(memberModel.getZipcode());
   		 orderModel.setOrder_receive_addr(memberModel.getAddr()+" " + memberModel.getAddr2());
         orderModel.setOrder_goods_name(goodsModel.getGoods_name());
         //orderModel.setOrder_trade_payer("�������� : 110-376-206254 ���ؿ�");
         
   		 if(orderModel.getOrder_memo() == ""){
   			 orderModel.setOrder_memo("����");
   		 }
         
         
         goodsModel = goodsService.goodsView(goods_num);
         
         mav.addObject("goodsModel", goodsModel);
         mav.addObject("orderModel", orderModel);
   		 mav.setViewName("orderBuyForm");
   		 return mav;
   		 
        }
        

        //�ֹ��ϱ� ó��
        @RequestMapping(value="/orderbuyOk.dog")
        public ModelAndView orderBuyOk(HttpServletRequest request, OrderModel orderModel){
        	
        	orderModel.setOrder_trans_num("�غ���"); //String���� �ٲٰ�  �غ��� ����
        	orderModel.setOrder_status("��ǰ�غ�");
        	
        	orderList = orderService.OrderList(orderModel);
        	
        	//ó�� �ֹ� ������ �ֹ���ȣ������ 1��
        	if(orderList.size() == 0){
        		orderModel.setOrder_trade_num(1);
        		orderService.OrderInsert(orderModel);
            	
            	mav.setViewName("orderOK"); 
            	
            	return mav;
        	}else{ 
        	
        	orderModel2 = (OrderModel) orderService.OrderTradeNum();
        	int order_trade_num =  orderModel2.getOrder_trade_num();
        
        	orderModel.setOrder_trade_num(order_trade_num+1);
        	
        	//���� ����
        	goodsModel = goodsService.goodsView(orderModel.getOrder_goods_num());
        	int amount = goodsModel.getGoods_amount() - orderModel.getOrder_goods_amount();
        	goodsModel.setGoods_amount(amount);
        	
        	goodsService.amountDown(goodsModel);
        	
        	orderService.OrderInsert(orderModel);        	
        	
        	//�����ϱ⿡�� �ֹ���ȣ�̾Ƴ���
        	OrderModel orderModel4 = new OrderModel(); 
        	orderModel4 = (OrderModel) orderService.OrdergetOne(orderModel.getOrder_trade_num());
        	      	    
        	mav.addObject("orderModel3", orderModel4);
        	mav.setViewName("orderOK"); 
        	
        	return mav;
        	}
        }
        
        
        //�ֹ�����Ʈ 
        @RequestMapping(value="/orderList.dog")
        public ModelAndView orderList(HttpServletRequest request, HttpSession session){
        	
        	session = request.getSession();
        	OrderModel orderModel = new OrderModel();
        	
        	String id = (String)session.getAttribute("session_member_id");
       
        	orderModel.setOrder_member_id(id);
        	
        	orderList = orderService.OrderList(orderModel);
        	
        	mav.addObject("orderList", orderList);
        	mav.setViewName("orderList");
        	return mav;
        }
        
        
        //�ֹ� ��ǰ ����
        @RequestMapping(value="/orderdelete.dog")
        public ModelAndView orderdelete(HttpServletRequest request, OrderModel orderModel){
        	
        	orderService.deleteOrder(orderModel);
        	
        	mav.setViewName("redirect:/order/orderList.dog"); 
        	return mav;
        }
        
        //�ٽ��� ���� ó��
        @RequestMapping(value="/basketorderForm.dog")
        public ModelAndView basketorderForm(HttpServletRequest request, HttpSession session ){
   		 
   		 session = request.getSession();
   		 BasketModel basketModel = new BasketModel();
   		 
   		 String id = (String)session.getAttribute("session_member_id");
   		 
   		 if(id != ""){
   			 
   		 basketModel.setBasket_member_id(id);	 
   		 
   		 basketList= basketService.BasketList(basketModel);
   		
   		 memberModel = memberService.getMember(id);
   		 
   		
   		 mav.addObject("basketList", basketList);
   		 mav.addObject("memberModel", memberModel);
   		 mav.setViewName("basketorderForm");
   		 return mav;
   		 
   		 }else{
   			 
   			 mav.setViewName("basket/basketAddError");
   			 return mav;
   		 }
   	 }
        
        //
        @RequestMapping(value="/basketorderForm1.dog")
   	 	public ModelAndView basketorderInsert(HttpServletRequest request, HttpSession session, OrderModel orderModel,MemberModel memberModel ){
   		 
   		 session = request.getSession();
   		 BasketModel basketModel = new BasketModel();
   		
   		 String id = (String)session.getAttribute("session_member_id");

   		 basketModel.setBasket_member_id(id);	 
   		 basketList= basketService.BasketList(basketModel);

   		 orderModel.setOrder_member_id(id);
   		 orderModel.setOrder_receive_zipcode(memberModel.getZipcode());
   		 orderModel.setOrder_receive_addr(memberModel.getAddr()+" " + memberModel.getAddr2());
     
        
   		 if(orderModel.getOrder_memo() == ""){
   			 orderModel.setOrder_memo("����");
   		 }
         
         
        
         mav.addObject("memberModel", memberModel);
         mav.addObject("basketList", basketList);
         mav.addObject("orderModel", orderModel);
   		 mav.setViewName("basketorderBuyForm");
   		 return mav;
   		 
        }
     
        
        
        @RequestMapping(value="/basketorderbuyOk.dog")
        public ModelAndView basketorderBuyOk(HttpServletRequest request, OrderModel orderModel){
        	
        	BasketModel basketModel = new BasketModel();
        	
        	basketModel.setBasket_member_id(orderModel.getOrder_member_id());
        	basketList= basketService.BasketList(basketModel);
        	
        	orderModel2 = (OrderModel) orderService.OrderTradeNum();
        	
        	int Order_trade_num = orderModel2.getOrder_trade_num();
        	System.out.println(Order_trade_num);
        	Order_trade_num += 1;
        	
        	
        	//��ٱ��� ���ż��� �˻�
        	for(int i=0; i < basketList.size(); i ++){
        		basketModel = basketList.get(i);
        		
        		goodsModel = goodsService.goodsView(basketModel.getBasket_goods_num());
        		int amount = goodsModel.getGoods_amount() - basketModel.getBasket_goods_amount();
        		
        		
        		if(amount < 0 ){
            		basketService.deleteBasket(basketModel);
            		mav.setViewName("basket/basketamountError"); 
            		return mav;
            	}
        	}
        	
        	
        	for(int i=0; i<basketList.size(); i++){
        		
        		basketModel = basketList.get(i);
        		
        		
        		
        		//���� ����
            	goodsModel = goodsService.goodsView(basketModel.getBasket_goods_num());
            	
            	int amount = goodsModel.getGoods_amount() - basketModel.getBasket_goods_amount();
            	
            	goodsModel.setGoods_amount(amount);
            	
            	goodsService.amountDown(goodsModel);
        		
        		
        		orderModel.setOrder_goods_num(basketModel.getBasket_goods_num());
        		orderModel.setOrder_goods_name(basketModel.getBasket_goods_name());
        		orderModel.setOrder_goods_price(basketModel.getBasket_goods_price());
        		orderModel.setOrder_goods_amount(basketModel.getBasket_goods_amount());
        		orderModel.setOrder_sum_money(basketModel.getBasket_goods_price() * basketModel.getBasket_goods_amount());
        		orderModel.setOrder_goods_image(basketModel.getBasket_goods_image());
        		orderModel.setOrder_trans_num("�غ���"); //String���� �ٲٰ�  �غ��� ����
            	orderModel.setOrder_status("��ǰ�غ�");
            	orderModel.setOrder_trade_num(Order_trade_num);
            	
            	
            	
            	orderService.OrderInsert(orderModel);
            	basketService.deleteBasket(basketModel);
            	
        	}
        
        	OrderModel orderModel3 = new OrderModel();
        	orderModel3.setOrder_member_id(orderModel.getOrder_member_id());
        	orderList = orderService.OrderList(orderModel3);
        
        	mav.addObject("orderModel4", orderList);  	
        	
        	
        	mav.setViewName("basketorderOK"); 
        	
        	return mav;
        }
        
        
        
        
        
}
