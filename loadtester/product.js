import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  vus: 2,
  duration: '30m'
};

const baseUrl = 'http://localhost:8082';

export default function () {
  const res = http.get(`${baseUrl}/product/100001`);
  check(res, {
    'is status 200': (r) => r.status === 200,
  });
  sleep(1);
}