package poc.ms.hexagonal.listener;

import org.hibernate.envers.RevisionListener;
import poc.ms.hexagonal.entity.RevisionEntityCustom;

public class RevisionListenerCustom implements RevisionListener {

    @Override
    public void newRevision(final Object entity) {
        var revision = (RevisionEntityCustom) entity;
//        revision.setAuditor("ADMIN");
    }

}
