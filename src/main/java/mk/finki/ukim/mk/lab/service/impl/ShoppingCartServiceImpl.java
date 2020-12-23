package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.model.ShoppingCart;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.enumerations.ShoppingCartStatus;
import mk.finki.ukim.mk.lab.model.exception.NoItemsInCartException;
import mk.finki.ukim.mk.lab.model.exception.OrderAlreadyExistsException;
import mk.finki.ukim.mk.lab.model.exception.OrderDoesNotExistException;
import mk.finki.ukim.mk.lab.model.exception.UserNotFoundException;
import mk.finki.ukim.mk.lab.repository.ShoppingCartRepository;
import mk.finki.ukim.mk.lab.repository.UserRepository;
import mk.finki.ukim.mk.lab.service.OrderService;
import mk.finki.ukim.mk.lab.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final OrderService orderService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   UserRepository userRepository,
                                   OrderService orderService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.orderService = orderService;
    }

    @Override
    public List<Order> listAllOrdersInShoppingCart(Long cartId) {
        if (this.shoppingCartRepository.findById(cartId).isEmpty()) {
            throw new NoItemsInCartException(cartId);
        }
        return this.shoppingCartRepository.findById(cartId).get().getOrders();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        User user = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
        if (this.shoppingCartRepository.findAllByUserAndStatus(user, ShoppingCartStatus.CREATED).isEmpty()) {
            ShoppingCart shoppingCart = new ShoppingCart(user);
            return this.shoppingCartRepository.save(shoppingCart);
        }
        return this.shoppingCartRepository.findAllByUserAndStatus(user, ShoppingCartStatus.CREATED).get();
    }

    @Override
    public ShoppingCart addOrderToShoppingCart(String username, Long orderId) {
        ShoppingCart cart = this.getActiveShoppingCart(username);
        Order order = this.orderService.findById(orderId).orElseThrow(() -> new OrderDoesNotExistException(orderId));
        if (cart.getOrders()
                .stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .collect(Collectors.toList()).size() > 0)
            throw new OrderAlreadyExistsException(orderId);
        cart.getOrders().add(order);
        return this.shoppingCartRepository.save(cart);
    }
}
