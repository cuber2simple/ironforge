package org.ironforge.biz;


import org.ironforge.transfer.Transfer;

public interface IronforgeBizService<BO, T,ID> extends Transfer<T, BO> {

    BO add(BO bo);

    BO edit(BO bo);

    BO findById(ID id);

}
