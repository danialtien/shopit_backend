package com.danialtien.shopit.services.impl;

import com.danialtien.shopit.model.entity.Notification;
import com.danialtien.shopit.model.entity.Orders;
import com.danialtien.shopit.repository.NotificationRepository;
import com.danialtien.shopit.services.GeneralService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class NotificationServiceImpl implements GeneralService<Notification> {

    @Autowired
    private NotificationRepository repository;
    @Override
    public List<Notification> getAll() {
        return repository.findAll();
    }

    @Override
    public Notification add(Notification object) {
        return repository.save(object);
    }

    @Override
    public Notification getById(int id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Notification update(int id, Notification object) {
        return null;
    }

    @Override
    public void remove(Notification object) {
        repository.delete(object);
    }

    public List<Notification> getNotificationByCustomerId(int customerId) {
        List<Notification> lists = new ArrayList<>();
        for (Notification notification : repository.findAll()) {
            if (notification.getCustomerId() == customerId) {
                lists.add(notification);
            }
        }
        return lists;
    }
}
