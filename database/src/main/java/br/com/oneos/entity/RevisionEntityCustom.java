package br.com.oneos.entity;

import br.com.oneos.listener.RevisionListenerCustom;
import lombok.Data;
import lombok.ToString;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "revinfo")
@RevisionEntity(RevisionListenerCustom.class)
@ToString(callSuper = true)
public class RevisionEntityCustom extends DefaultRevisionEntity {
    private String auditor;
}
