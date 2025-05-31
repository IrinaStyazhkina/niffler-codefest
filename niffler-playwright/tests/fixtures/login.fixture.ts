import { test as base } from '@playwright/test';
import { mockJSBridge } from 'tests/mocks/jsBridge';

type LoginFixture = {
    mockJSBridgeAuthToken: () => void;
};

export const test = base.extend<LoginFixture>({
    mockJSBridgeAuthToken: async ({ context}, use) => {
        await use(async () => {
            const token = "eyJraWQiOiI3NTJmNjRkOC0zYzI5LTRkMDQtYWE5NC0xZDcyZGJkODI5NWMiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJzdGFnZSIsImF1ZCI6ImNsaWVudCIsImF6cCI6ImNsaWVudCIsImF1dGhfdGltZSI6MTc0ODU4MzIyOSwiaXNzIjoiaHR0cHM6Ly9hdXRoLm5pZmZsZXItc3RhZ2UucWEuZ3VydSIsImV4cCI6MTc0ODU4Njg3MiwiaWF0IjoxNzQ4NTgzMjcyLCJqdGkiOiJhMjNmNWMyOS05OWQ3LTRkYTEtOTAwMy1hNjljOGU5NjA5ODAiLCJzaWQiOiJtaUx5M0gtLTc3R09tM1J4eTU3VWo2NVZCQU9KZXBVQ1pQQ3pjakl3SW1FIn0.vAiN9IUlFnVUf1aKnegK0Zq61SYnJRiOrF5w2Yr1fAMqG_E_S0rEik81dUkXYGUQomDkHaVCr48MxPmDyBH263muBvBpW_IGaT7E0iamg79wdxBrAUBE4YSJT0ZtHTuu-7CMDMhkf9SFlmIiMB8N3mDsTHGvkr6OMzC-22JAKRqeFv1H8kgpXrVH-4Gih9H5pJkzQgu2eBzABGQbXYFwJ_9ceFNXuhV9SbQzLBAI9szS5NpF_EpSW9TG2JeWZRAMa5f2jAWGbcPAu8wuqeGA67FXQ9cvvE8FnknF1I7c6L72ZSqDS6cRs9UXq7Cho7JSrt3L3UwMeCWYoRomotJALw"
            await mockJSBridge(context, token);
        });
    }
});

export { expect} from '@playwright/test';
