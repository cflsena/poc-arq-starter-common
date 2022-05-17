package br.com.oneos.listener;

import org.hibernate.envers.RevisionListener;
import br.com.oneos.entity.RevisionEntityCustom;

public class RevisionListenerCustom implements RevisionListener {

    @Override
    public void newRevision(final Object entity) {
        var revision = (RevisionEntityCustom) entity;
//        revision.setAuditor("ADMIN");
    }

}
