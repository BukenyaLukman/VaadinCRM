package com.vaadin.learn.crm.UI;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.learn.crm.backend.Service.ContactService;
import com.vaadin.learn.crm.backend.entity.Company;
import com.vaadin.learn.crm.backend.entity.Contact;


@Route("")
public class MainView extends VerticalLayout {
    private ContactService contactService;
    Grid<Contact> grid = new Grid<>(Contact.class);
    public MainView(ContactService contactService) {
        this.contactService = contactService;
        addClassName("list-view");
        configureGrid();
        setSizeFull();

        add(grid);
    }

    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();
        grid.removeColumnByKey("company");
        grid.setColumns("firstName","lastName","email","status","company");
        grid.addColumn(contact ->{
            Company company = contact.getCompany();
            return company == null ? "-":company.getName();
        }).setHeader("Company");
        grid.getColumns().forEach(col-> col.setAutoWidth(true));

        add(grid);
        updateList();
    }

    private void updateList() {
         grid.setItems(contactService.findAll());
    }

}
