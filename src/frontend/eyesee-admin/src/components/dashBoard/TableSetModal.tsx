import { Dispatch, SetStateAction } from "react";
import GridIcon from "@/assets/icons/GridIcon.svg";
import CloseIcon from "@/assets/icons/CloseIcon.svg";

type TableSetModalProps = {
  examStudentNumber: number;
  row: number;
  column: number;
  setRow: Dispatch<SetStateAction<number>>;
  setColumn: Dispatch<SetStateAction<number>>;
  setTableModalOpen: Dispatch<SetStateAction<boolean>>;
};

const TableSetModal = ({
  examStudentNumber,
  row,
  column,
  setRow,
  setColumn,
  setTableModalOpen,
}: TableSetModalProps) => {
  // row를 설정하면 column이 자동 계산
  const handleRowChange = (newRow: number) => {
    if (newRow > 0) {
      setRow(newRow);
      setColumn(Math.ceil(examStudentNumber / newRow));
    }
  };

  // column을 설정하면 row가 자동 계산
  const handleColumnChange = (newColumn: number) => {
    if (newColumn > 0) {
      setColumn(newColumn);
      setRow(Math.ceil(examStudentNumber / newColumn));
    }
  };

  return (
    <div className="w-screen h-screen fixed bg-[rgba(25,26,30,0.6)] z-50 flex justify-center items-center">
      <div className="relative w-[420px] flex flex-col items-center gap-4 pt-24 pb-12 bg-[#0E1D3C]">
        <div className="absolute top-5 left-0 text-white flex justify-between w-full px-5">
          <div className="flex items-center gap-4 text-lg">
            <GridIcon />
            그리드 설정
          </div>
          <CloseIcon onClick={() => setTableModalOpen(false)} />
        </div>
        <div className="flex gap-10 text-2xl">
          <div className="text-white">행</div>
          <input
            className="w-32 text-center rounded-sm"
            type="number"
            value={row}
            onChange={(e) => handleRowChange(Number(e.target.value))}
            min={1}
          />
        </div>
        <div className="flex gap-10 text-2xl">
          <div className="text-white">열</div>
          <input
            className="w-32 text-center rounded-sm"
            type="number"
            value={column}
            onChange={(e) => handleColumnChange(Number(e.target.value))}
            min={1}
          />
        </div>
      </div>
    </div>
  );
};

export default TableSetModal;
