package springCorePrinciples.basic.order;

public interface OrderService {
    Order createOrder(Long memberId,String itmeName,int itemPrice);
}
