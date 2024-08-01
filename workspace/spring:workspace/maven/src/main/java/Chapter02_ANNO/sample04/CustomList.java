package Chapter02_ANNO.sample04;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomList extends ArrayList<SungJukDTO2> {

}
