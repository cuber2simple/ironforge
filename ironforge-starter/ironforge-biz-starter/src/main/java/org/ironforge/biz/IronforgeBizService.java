package org.ironforge.biz;


public interface IronforgeBizService<BO, ID> {

    BO add(BO bo);

    BO edit(BO bo);

    BO findById(ID id);

}
