import { ICompany } from "./iPerson";

interface IJob {
  id: number;
  name: string;
  description: string;
  company: ICompany;
}

export default IJob;
