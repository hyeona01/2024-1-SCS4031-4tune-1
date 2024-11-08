"use client";

import TestInfo from "@/components/dashBoard/TestInfo";
import CheatingVideo from "@/components/userDetail/CheatingVideo";
import TimeLine from "@/components/userDetail/TimeLine";
import { useUserDetail } from "@/hooks/api/useUserDetail";
import { timeLineType } from "@/types/timeLine";
import { useParams } from "next/navigation";
import React, { useEffect, useState } from "react";

const UserDetailPage = () => {
  const [userDetailData, setUserDetailData] = useState<timeLineType>();
  const [vidieoNum, setVideoNum] = useState(0);

  const { userId, examId } = useParams();
  const { data } = useUserDetail(examId as string, userId as string);

  useEffect(() => {
    if (data) {
      setUserDetailData(data.data);
    }
  }, [data]);

  return (
    <>
      {userDetailData ? (
        <div className="flex w-screen h-screen bg-[#0E1D3C]">
          <TimeLine timeLineData={userDetailData} setVideoNum={setVideoNum} />
          <div className="grow text-white p-10">
            <TestInfo examName="융합캡스톤디자인 중간시험" examDuration={120} />
            <div>
              <CheatingVideo
                cheatingVideo={userDetailData.cheatingVideos[vidieoNum]}
                cheatingType={
                  userDetailData.cheatingStatistics[vidieoNum].cheatingTypeName
                }
                cheatingCounts={
                  userDetailData.cheatingStatistics[vidieoNum].cheatingCount
                }
              />
              <div className="flex gap-5 py-5">
                {userDetailData.cheatingVideos.map((video, index) => (
                  <div
                    key={index}
                    onClick={() => setVideoNum(index)}
                    className="h-28 max-w-48 rounded-sm overflow-hidden"
                  >
                    <video src={video.filepath} />
                  </div>
                ))}
              </div>
            </div>
          </div>
        </div>
      ) : (
        <div>로딩 중</div>
      )}
    </>
  );
};

export default UserDetailPage;
