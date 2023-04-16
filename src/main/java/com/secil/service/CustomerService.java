package com.secil.service;

import com.secil.dto.request.ActivateRequestDto;
import com.secil.dto.request.LoginRequestDto;
import com.secil.dto.request.RegisterRequestDto;
import com.secil.dto.request.UpdateEmailOrPasswordRequestDto;
import com.secil.dto.response.RegisterResponseDto;
import com.secil.entity.Customer;
import com.secil.entity.EStatus;
import com.secil.entity.JoinEntities.CustomerOrderPersonelRestaurant;
import com.secil.exception.ErrorType;
import com.secil.exception.YemekSepetiException;
import com.secil.mapper.ICustomerMapper;
import com.secil.repository.CustomerOrderPersonelRestaurantRepository;
import com.secil.repository.ICustomerRepository;
import com.secil.utility.CodeGenerator;
import com.secil.utility.ServiceManager;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CustomerService extends ServiceManager<Customer,Integer> {
    private final ICustomerRepository customerRepository;
    private final CustomerOrderPersonelRestaurantRepository customerOrderPersonelRestaurantRepository;
    public CustomerService(ICustomerRepository customerRepository,CustomerOrderPersonelRestaurantRepository customerOrderPersonelRestaurantRepository){
        super(customerRepository);
        this.customerRepository=customerRepository;
        this.customerOrderPersonelRestaurantRepository=customerOrderPersonelRestaurantRepository;
    }
    public RegisterResponseDto register(RegisterRequestDto dto) {
        Customer customer = ICustomerMapper.INSTANCE.toCustomer(dto);
        Optional<Customer> customer1 = customerRepository.findOptionalByEmail(dto.getEmail());
        if (customer1.isEmpty()) {
            if (!dto.getPassword().equals(dto.getRepassword())) {
                throw new YemekSepetiException(ErrorType.PASSWORD_ERROR);
            } else {
                customer.setActivationCode(CodeGenerator.generateCode());
                save(customer);
            }
        }else{
            throw new YemekSepetiException(ErrorType.USER_FOUND);
        }
        RegisterResponseDto responseDto=ICustomerMapper.INSTANCE.toDto(customer);
        return responseDto;
        }
        public boolean activateStatus (ActivateRequestDto dto){
        Optional<Customer> customer=findById(dto.getId());
        if(customer.isEmpty()){
            throw new YemekSepetiException(ErrorType.USER_NOT_FOUND);
        }else if(customer.get().getActivationCode().equals(dto.getActivationCode())){
            customer.get().setStatus(EStatus.ACTIVE);
            update(customer.get());
            return true;
        }
        throw new YemekSepetiException(ErrorType.ACTIVATE_CODE_ERROR);
    }
    public String login(LoginRequestDto dto){
        Optional<Customer> customer=customerRepository.findOptionalByEmail(dto.getEmail());
        if(customer.isEmpty()){
            throw new YemekSepetiException(ErrorType.LOGIN_ERROR);
        }else if(!customer.get().getStatus().equals(EStatus.ACTIVE)){
            throw new YemekSepetiException(ErrorType.ACTIVATE_CODE_ERROR);
        }
        return "Giriş başarılı";
    }
    public Boolean update(UpdateEmailOrPasswordRequestDto dto){
        Optional<Customer> customer=customerRepository.findById(dto.getCustomer_id());
        if(customer.isEmpty()){
            throw new YemekSepetiException(ErrorType.USER_NOT_FOUND);
        }
        customer.get().setEmail(dto.getEmail());
        customer.get().setPassword(dto.getPassword());
        update(customer.get());
        return true;
    }
    public List<Customer> findAll(){
        List<Customer> customer=customerRepository.findAll();
        return customer;
    }
    public List<String> findByName(){

        return customerRepository.findByName();
    }
    public List<CustomerOrderPersonelRestaurant> findOrders(Integer customerId){
        return customerOrderPersonelRestaurantRepository.findOrders(customerId);
    }

}
